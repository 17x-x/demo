package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter("*")
public class CharsetFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        HttpServletResponse resp= (HttpServletResponse) servletResponse;
        //设置请求的编码格式
        req.setCharacterEncoding("UTF-8");
        //设置响应的内容类型；文本
        resp.setContentType("text/html;charset=utf-8");
        //设置响应的字符编码
        resp.setCharacterEncoding("UTF-8");
        //过滤链向下传递
        filterChain.doFilter(req,resp);

    }

    @Override
    public void destroy() {

    }
}
