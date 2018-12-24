package com.epam.race.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(urlPatterns = { "/*" },
        initParams = {
                @WebInitParam(name = EncodingFilter.ENCODING, value = "UTF-8")})
public class EncodingFilter implements Filter {
    private String code;
    public static final String ENCODING = "encoding";

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        code = fConfig.getInitParameter(ENCODING);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        String codeRequest = request.getCharacterEncoding();

        if (code != null && !code.equalsIgnoreCase(codeRequest)) {
            request.setCharacterEncoding(code);
            response.setCharacterEncoding(code);
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        code = null;
    }
}
