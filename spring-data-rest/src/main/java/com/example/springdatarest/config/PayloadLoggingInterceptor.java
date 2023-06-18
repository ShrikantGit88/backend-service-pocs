package com.example.springdatarest.config;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;


public class PayloadLoggingInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(PayloadLoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("Incoming request: {} {}", request.getMethod(), request.getRequestURI());
        if (request.getContentLength() > 0) {
            logger.debug("Request payload: {}", request.getInputStream().toString(), StandardCharsets.UTF_8);
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.debug("Outgoing response: {} {}", response.getStatus(), response.getContentType());
        if (response.getContentType() != null && response.getContentType().startsWith("application/json")) {
            logger.debug("Response payload: {}", response, StandardCharsets.UTF_8);
        }
    }


}