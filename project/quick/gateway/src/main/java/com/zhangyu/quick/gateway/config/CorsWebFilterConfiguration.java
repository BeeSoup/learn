package com.zhangyu.quick.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * 跨域的配置
 */
@Configuration
public class CorsWebFilterConfiguration {

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(Boolean.TRUE);
        config.addAllowedOrigin(CorsConfiguration.ALL);
        config.addAllowedHeader(CorsConfiguration.ALL);
        config.addAllowedMethod(CorsConfiguration.ALL);
        config.setMaxAge(3600L); //一小时间跨域

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());

        source.registerCorsConfiguration("/**", config);

        return new CorsWebFilter(source);

        //return (ServerWebExchange ctx, WebFilterChain chain) -> {
        //			ServerHttpRequest request = ctx.getRequest();
        //			if (!CorsUtils.isCorsRequest(request)) {
        //				return chain.filter(ctx);
        //			}
        //
        //			HttpHeaders requestHeaders = request.getHeaders();
        //			ServerHttpResponse response = ctx.getResponse();
        //			HttpMethod requestMethod = requestHeaders.getAccessControlRequestMethod();
        //			HttpHeaders headers = response.getHeaders();
        //			headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, requestHeaders.getOrigin());
        //			headers.addAll(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, requestHeaders.getAccessControlRequestHeaders());
        //			if (requestMethod != null) {
        //				headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, requestMethod.name());
        //			}
        //			headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
        //			headers.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "all");
        //			headers.add(HttpHeaders.ACCESS_CONTROL_MAX_AGE, "3600");
        //			if (request.getMethod() == HttpMethod.OPTIONS) {
        //				response.setStatusCode(HttpStatus.OK);
        //				return Mono.empty();
        //			}
        //			return chain.filter(ctx);
        //————————————————

    }

}
