package com.zy.newsource.pojo.datasource.mybatis.utils;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO...
 *
 * @author zhang
 * @since 2021/2/19
 */
public class GeneratorDisplay {


    public static void main(String[] args) throws Exception {
        try {
            GeneratorDisplay generatorSqlMap = new GeneratorDisplay();
            generatorSqlMap.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void generator() throws Exception {

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        // 指定 逆向工程配置文件
        File configFile = new File("src\\main\\resources\\generator\\generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);

    }
}
