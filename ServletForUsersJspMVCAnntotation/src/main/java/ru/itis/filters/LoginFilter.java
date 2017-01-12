package ru.itis.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.itis.service.UsersService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Repository
public class LoginFilter implements Filter {
    @Autowired
    UsersService usersService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
        Cookie cookie[] = ((HttpServletRequest) servletRequest).getCookies();
        boolean find = false;
        if (cookie != null){
            for (int i = cookie.length-1; i > 0; i--){
                find = (usersService.findUserByToken(cookie[i].getValue()) != null) ? true : false;
                if (find) {
                    filterChain.doFilter(servletRequest, servletResponse);
                    break;
                }
            }
        }
        if (!find){
            ((HttpServletResponse)servletResponse).sendRedirect("/login");
        }
    }

    @Override
    public void destroy() {

    }
}
