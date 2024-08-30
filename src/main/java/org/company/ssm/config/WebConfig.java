package org.company.ssm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")//添加一个跨域映射，任何请求都允许跨域访问
                .allowedOrigins("*")//允许跨域访问的来源地址，*任意地址
                .allowedMethods("GET", "POST", "PUT", "OPTIONS", "DELETE")//允许的Http方法 全部是*
                .allowedHeaders("*");//允许所有的请求头
    }
}
