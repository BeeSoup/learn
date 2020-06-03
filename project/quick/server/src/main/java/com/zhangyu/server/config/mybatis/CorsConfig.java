package com.zhangyu.server.config.mybatis;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * http://www.123.com/index.html 调用 http://www.123.com/server.php （非跨域）
 *
 * http://www.123.com/index.html 调用 http://www.456.com/server.php （主域名不同:123/456，跨域）
 *
 * http://abc.123.com/index.html 调用 http://def.123.com/server.php （子域名不同:abc/def，跨域）
 *
 * http://www.123.com:8080/index.html 调用 http://www.123.com:8081/server.php （端口不同:8080/8081，跨域）
 *
 * http://www.123.com/index.html 调用 https://www.123.com/server.php （协议不同:http/https，跨域）
 *
 * 请注意：localhost和127.0.0.1虽然都指向本机，但也属于跨域。
 * ————————————————
 * 版权声明：本文为CSDN博主「L瑜」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/lambert310/article/details/51683775
 * 解决办法：
 *
 * 1、JSONP：
 *
 * 使用方式就不赘述了，但是要注意JSONP只支持GET请求，不支持POST请求。
 *
 * 2、代理：
 *
 * 例如www.123.com/index.html需要调用www.456.com/server.php，可以写一个接口www.123.com/server.php，由这个接口在后端去调用www.456.com/server.php并拿到返回值，然后再返回给index.html，这就是一个代理的模式。相当于绕过了浏览器端，自然就不存在跨域问题。
 *
 * 3、PHP端修改header（XHR2方式）
 *
 * 在php接口脚本中加入以下两句即可：
 *
 * header('Access-Control-Allow-Origin:*');//允许所有来源访问
 *
 * header('Access-Control-Allow-Method:POST,GET');//允许访问的方式
 * ————————————————
 * 版权声明：本文为CSDN博主「L瑜」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/lambert310/article/details/51683775
 *
 *
 * 网关配置跨域，然后业务层面的代码，不配置跨域信息
 *
 * 协议不同
 * 端口不同
 * 主域名不同
 * 子域名不同
 * 跨域
 */
//@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(CorsConfiguration.ALL)
                .allowedHeaders(CorsConfiguration.ALL)
                .allowedHeaders(CorsConfiguration.ALL)
                .allowCredentials(true)
                .maxAge(3600);
        //一小时内不需要再预检测（发OPTIONS）请求

    }
}
