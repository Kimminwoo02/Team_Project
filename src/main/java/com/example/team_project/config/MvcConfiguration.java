package com.example.team_project.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
    @Value("${com.example.upload}")
    String potoAdd;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/**")
                .addResourceLocations("file://"+potoAdd,"classpath:/templates/","classpath:/templates/img/", "classpath:/static/","classpath:/config/");
    }
}


