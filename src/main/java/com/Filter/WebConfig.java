package com.Filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor());
        //所有路径都被拦截
        registration.addPathPatterns("/**");
        //添加不拦截路径
        registration.excludePathPatterns("/", "/admin/login", "", "/admin/checkcode", "/app/*", "/pages/login.html", "/**/*.js", "/**/*.css", "/**/*.json", "/**/*.icon","/images/*.png","/images/*.jpg","/lay/**/*.js"
        ,"/public/*","/user/*"

        );
    }
}