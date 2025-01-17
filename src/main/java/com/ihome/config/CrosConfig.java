package com.ihome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CrosConfig {
    //http://www.baidu.com   请求方式   cookie   请求头
    @Bean
    public CorsFilter getCorsFilter(){

        //配置跨域的拦截规则
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:8080");
        config.addAllowedOrigin("http://127.0.0.1:8080");
        config.addAllowedOrigin("http://localhost");
        config.addAllowedOrigin("http://127.0.0.1");
        config.getAllowCredentials();

        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PATCH");
        config.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        //配置拦截路径的匹配
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",config);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
