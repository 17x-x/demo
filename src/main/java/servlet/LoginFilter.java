package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        //用户访问首页或者欢迎页面以及其他你允许游客访问的页面，都要包含在if条件里
        if (uri.contains("login")||uri.contains("Login")){
            filterChain.doFilter(request,response);
        }else {
            //获取session对象
            HttpSession session = request.getSession();
            //获取session有效的变量username
            String username = (String) session.getAttribute("username");
            if (username==null||username.equals(null)){
                //没有登陆的游客，让他转向到登陆页面
                response.sendRedirect("login.html");
            }else {
                //登陆过的合法用户
                filterChain.doFilter(request,response);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
