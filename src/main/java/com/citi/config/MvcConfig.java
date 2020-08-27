package com.citi.config;

import com.citi.intercepter.LoginRequiredInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: chenle
 * @Date: 2020/8/25 - 13:56
 * @Description: com.citi.config
 * @version: 1.0
 */

@Configuration
public class MvcConfig implements WebMvcConfigurer {


    @Autowired
    private LoginRequiredInterceptor loginRequiredInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 静态资源随便访问
        registry.addInterceptor(loginRequiredInterceptor)
                .excludePathPatterns("/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg", "/**/*.jpeg","/login");
//                .addPathPatterns("/login");;

    }
}
