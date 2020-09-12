package com.uday.learning.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;



@Component
@Order(1)
public class CommonFilter implements Filter {

    Logger log = LoggerFactory.getLogger(CommonFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        log.info("Starting a transaction for req : {}", req.getRequestURI());

        chain.doFilter(request, response);
        log.info("Committing a transaction for req : {}", req.getRequestURI());
    }

    // other methods
}

//@WebFilter(urlPatterns = {"/login/examinar/*"})
//public class CommonFilter implements Filter {
//
//    Logger log = LoggerFactory.getLogger(CommonFilter.class);
//
//    private FilterConfig filterConfig;
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) req;
//        final String tokenId = request.getHeader("token");
//        log.info("CandidateFilter >> {}",tokenId);
//        chain.doFilter(req, res);
//    }
//
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        this.filterConfig = filterConfig;
//    }
//
//    @Override
//    public void destroy() {
//    }
//}
