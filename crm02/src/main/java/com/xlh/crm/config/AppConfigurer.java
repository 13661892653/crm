package com.xlh.crm.config;

import com.xlh.crm.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by ycp on 2017/3/18.
 */
@Configuration
public class AppConfigurer extends WebMvcConfigurerAdapter {

    @Override
   public void addInterceptors(InterceptorRegistry registry){
       registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/api/**");
       super.addInterceptors(registry);
    }
}
