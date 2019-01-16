package com.epam.race.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(value = "/jsp/*", dispatcherTypes = {
        DispatcherType.FORWARD})
public class PageFilter implements Filter {

    private static final String PAGE = "page";

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        request.getSession().setAttribute(PAGE, request.getServletPath());

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}