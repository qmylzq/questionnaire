package com.zqq.questionnaire.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ author: 曲梦瑶
 * @ date: 2020/3/7-12 : 34
 */
@Configuration
public class PageController implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index.html");
        registry.addViewController("/hello").setViewName("../templates/hello.html");
    }
}

