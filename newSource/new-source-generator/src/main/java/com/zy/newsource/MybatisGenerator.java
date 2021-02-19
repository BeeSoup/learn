package com.zy.newsource;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * TODO...
 *
 * @author zhang
 * @since 2021/2/18
 */
@NoArgsConstructor
public class MybatisGenerator {

    // 包路徑
    static String parentPackage = "com.zy.newsourcce.pojo.datasource";
    // 数据库相关配置
    static String dbUrl = "jdbc:mysql://101.37.81.92:3306/new?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true";
    static String dbUserName = "root";
    static String dbPassWord = "zhangyu110";

    // static String driverName = "oracle.jdbc.driver.OracleDriver";
    static String driverName = "com.mysql.cj.jdbc.Driver";
    static DbType dbType = DbType.MYSQL;
    // 所需的表
    static String tables = "users:Users";

    static String moduleName = "";


    public static void main(String[] args) {
        if (args.length >= 7) {
            parentPackage = args[0];
            driverName = args[1];
            dbUrl = args[2];
            dbUserName = args[3];
            dbPassWord = args[4];
            dbType = (args[5].equals("oracle") ? DbType.ORACLE : DbType.MYSQL);// 暂时只考虑这两种数据库
            tables = args[6];
        }

        if (StringUtils.isNotBlank(tables)) {
            String tableArr[] = tables.split(",");
            String[] tableName = {""};
            for (int i = 0; i < tableArr.length; i++) {
                tableName[0] = tableArr[i].split("\\:")[0];
                String entityName = tableArr[i].split("\\:")[1];
                generator(tableName, entityName);
            }
        }
    }

    public static void generator(String[] tableNames, String entityName) {

        if (true) {
            Cfg cfg = new Cfg();
            cfg.setTableNames(tableNames);
            cfg.setNeedToGenMapperXml(true); // 生成mapper文件
            cfg.setNeedToGenService(false); // 不生成service
            cfg.setNeedToGenController(false); // 不生成controller
            cfg.setEntityName(entityName);
            gen(cfg);
        }

    }

    private static void gen(Cfg cfg) {
        // 代码生成器
        ExtendedAutoGenerator mpg = new ExtendedAutoGenerator();

        // =============================全局配置===============================
        String projectPath = System.getProperty("user.dir") + "\\" + moduleName;
        GlobalConfig gc = new GlobalConfig()
                // 生成文件的位置
                .setFileOverride(true).setOutputDir(projectPath + "/src/main/java")
                // 主键生成策略 生成BaseResultMap和BaseColumnList
                .setBaseResultMap(true)
                .setIdType(IdType.ASSIGN_ID)
                .setBaseColumnList(true)
                .setOpen(false)
                .setKotlin(false).setAuthor("zy");
        if (!StringUtils.isBlank(cfg.getEntityName())) {
            gc.setMapperName(cfg.getEntityName() + "Mapper").setEntityName(cfg.getEntityName()).setControllerName("");
        }
        mpg.setGlobalConfig(gc);

        // ================================数据源配置============================
        DataSourceConfig dsc = new DataSourceConfig();
        // 用户名、密码、驱动、url
        dsc.setDbType(dbType).setDriverName(driverName)
                .setUrl(dbUrl).setUsername(dbUserName).setPassword(dbPassWord);
        mpg.setDataSource(dsc);

        // ===============================包名配置：父包.模块.controller===============================
        PackageConfig pc = new PackageConfig();
        // 父包名 模块名
        pc.setParent(parentPackage).setEntity("entity").setMapper("dao");
        mpg.setPackageInfo(pc);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController("");   // 不生成controller
        templateConfig.setService("");  // 不生成service
        templateConfig.setServiceImpl("");  // 不生成serviceImpl
        templateConfig.setXml(null);    // 不在当前目录生成xml
        mpg.setTemplate(templateConfig);

        // 在指定目录下生成*Mapper.xml
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // TODO
            }
        };
        List<FileOutConfig> focList = new ArrayList();
        if (cfg.isNeedToGenMapperXml()) {
            focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输入文件名称
                    return projectPath + "/src/main/resources/mapper/common/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                }
            });
        }
        injectionConfig.setFileOutConfigList(focList);
        mpg.setCfg(injectionConfig);

        // =====================================策略配置==================================
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setTableFillList(Arrays.asList(
                new TableFill("created_time", FieldFill.INSERT),
//                new TableFill("create_date", FieldFill.INSERT),
//                new TableFill("create_time", FieldFill.INSERT),
//                new TableFill("last_user_id", FieldFill.INSERT_UPDATE),
//                new TableFill("last_date", FieldFill.INSERT_UPDATE),
                new TableFill("updated_time", FieldFill.INSERT_UPDATE)
        ));

        if (cfg.getTableNames() != null) {
            strategy.setInclude(cfg.getTableNames());
        } else {
            strategy.setInclude(scanner("表名"));
        }
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);

        mpg.execute();
    }

    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(("请输入" + tip + "："));
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (!StringUtils.isBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    private static class ExtendedAutoGenerator extends AutoGenerator {
        @Override
        public ConfigBuilder pretreatmentConfigBuilder(ConfigBuilder config) {
            return super.pretreatmentConfigBuilder(config);
        }
    }

    @Data
    private static class Cfg {
        private String[] tableNames;
        private String projectPath;
        private boolean needToGenMapperXml = false;
        private boolean needToGenService = false;
        private boolean needToGenController = false;
        private String entityName;

        public String[] getTableNames() {
            return tableNames;
        }

        public void setTableNames(String[] tableNames) {
            this.tableNames = tableNames;
        }

        public String getProjectPath() {
            return projectPath;
        }

        public void setProjectPath(String projectPath) {
            this.projectPath = projectPath;
        }

        public boolean isNeedToGenMapperXml() {
            return needToGenMapperXml;
        }

        public void setNeedToGenMapperXml(boolean needToGenMapperXml) {
            this.needToGenMapperXml = needToGenMapperXml;
        }

        public boolean isNeedToGenService() {
            return needToGenService;
        }

        public void setNeedToGenService(boolean needToGenService) {
            this.needToGenService = needToGenService;
        }

        public boolean isNeedToGenController() {
            return needToGenController;
        }

        public void setNeedToGenController(boolean needToGenController) {
            this.needToGenController = needToGenController;
        }
    }
}
