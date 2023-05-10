package com.example.springbootdemo.config;

import com.example.springbootdemo.interceptor.FlagTrackInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author guocang.shi
 */
@Configuration
public class CustomInterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private FlagTrackInterceptor flagTrackInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(flagTrackInterceptor);
    }
}
