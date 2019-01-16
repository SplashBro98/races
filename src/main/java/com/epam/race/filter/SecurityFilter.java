package com.epam.race.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter( urlPatterns = "/jsp/*",initParams = { @WebInitParam(name = "INDEX_PATH", value = "/index.jsp") })
public class SecurityFilter implements Filter {

    private static final String REFERER = "Referer";
    private String indexPath;
    @Override
    public void init(FilterConfig filterConfig) {
        indexPath = filterConfig.getInitParameter("INDEX_PATH");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String referer = request.getHeader(REFERER);
        if (referer == null) {
            response.sendRedirect(request.getContextPath() + indexPath);
        }

        filterChain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
