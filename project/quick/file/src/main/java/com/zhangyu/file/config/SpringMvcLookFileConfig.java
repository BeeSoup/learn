package com.zhangyu.file.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class SpringMvcLookFileConfig implements WebMvcConfigurer {

    /**
     * 配置查看 文件
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //设置上传路径，放项目的相对路径了
        // 启动参数里，可以配置，用配置比较好，动态配置，放properties也可以
        String projectPath = System.getProperty("user.dir"); //项目地址
        //判断系统吧，感觉要，windows 和unix /linux
        //
        String osName = System.getProperty("os.name");

        log.info(String.format("handle-----osName: %s", osName));
        //大小写，win不区分，所有可以写大写
        String pathChar = "/SaveFile/";
        //win
        if (osName != null && osName.toLowerCase().startsWith("win")) {
            pathChar = "\\SaveFile\\";
        }
        //file 对于txt会下载
        String fullPathDir = "file:" + projectPath + pathChar;
        log.info(String.format("handle-----fullPathDir: %s", fullPathDir));
        registry.addResourceHandler("/static/**").addResourceLocations(fullPathDir);

    }
}
