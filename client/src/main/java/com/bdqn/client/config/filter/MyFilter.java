package com.bdqn.client.config.filter;

import com.bdqn.client.config.CustometRequestWrapper;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * ClassName: MyFilter
 * create by:  xyf
 * description: TODO
 * create time: 2019/10/5 0005 下午 1:57
 */
@Component
@WebFilter(filterName = "bodyFilter", urlPatterns = "/*")
@Order(1)
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String url = new String(httpServletRequest.getRequestURI());

        //只过滤/actuator/bus-refresh请求
        if (!url.endsWith("/bus-refresh")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        //使用HttpServletRequest包装原始请求达到修改post请求中body内容的目的
        CustometRequestWrapper requestWrapper = new CustometRequestWrapper(httpServletRequest);

        filterChain.doFilter(requestWrapper, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
