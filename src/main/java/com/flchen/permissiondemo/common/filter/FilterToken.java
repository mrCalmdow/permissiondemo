package com.flchen.permissiondemo.common.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author feilongchen
 * @since 2018-08-15 10:49 AM
 */
@Slf4j
public class FilterToken extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
		log.info("toke filter dofilter");
		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}
}
