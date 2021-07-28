/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/7/28  zhangyu30939  新增
 * ========    =======  ============================================
 */
package com.zy.newsource;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// 1、打包方式需要调整为war
// 2、去掉内嵌tomcat
// 3、增加servlet api的依赖
// 4、war 启动指定启动类
public class WarApplication extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 指向application启动类
        return builder.sources(NewSourceApplication.class);
    }
}
