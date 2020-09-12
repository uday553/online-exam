package com.uday.learning.config;

import com.uday.learning.filter.CommonFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    public FilterRegistrationBean<CommonFilter> loggingFilter() {
        FilterRegistrationBean<CommonFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new CommonFilter());
        registrationBean.addUrlPatterns("/examiner/*");
        registrationBean.addUrlPatterns("/candidate/*");
        return registrationBean;
    }
}
