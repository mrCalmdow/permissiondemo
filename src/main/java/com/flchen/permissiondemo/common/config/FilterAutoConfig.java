package com.flchen.permissiondemo.common.config;

import com.flchen.permissiondemo.common.filter.FilterToken;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * @author feilongchen
 * @since 2018-08-15 10:44 AM
 */
@Configuration
public class FilterAutoConfig {

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		//TODO 实例化FilterRegistrationBean时，赋值filter
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(filterToken());
		filterRegistrationBean.addUrlPatterns("/member/*");
		filterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE + 1);
		return filterRegistrationBean;
	}

	@Bean
	public FilterToken filterToken() {
		return new FilterToken();
	}
}
