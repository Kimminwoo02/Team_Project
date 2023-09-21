package com.example.team_project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/", "classpath:/static/","classpath:/config/");
    }
}


