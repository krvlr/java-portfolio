package ru.kpfu.filter;

import org.springframework.beans.factory.annotation.Autowired;
import ru.kpfu.service.UserService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProfileFilter implements Filter {

    @Autowired
    private UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, filterConfig.getServletContext());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Cookie cookie[] = ((HttpServletRequest) servletRequest).getCookies();
        boolean find = false;
        if (cookie != null){
            filterChain.doFilter(servletRequest, servletResponse);
            /*for (int i = cookie.length-1; i > 0; i--){
                find = (userService.findByToken(cookie[i].getValue()) != null) ? true : false;
                if (find) {
                    filterChain.doFilter(servletRequest, servletResponse);
                    break;
                }
            }*/
        }
        if (!find){
            ((HttpServletResponse)servletResponse).sendRedirect("/login");
        }
    }

    @Override
    public void destroy() {

    }
}
