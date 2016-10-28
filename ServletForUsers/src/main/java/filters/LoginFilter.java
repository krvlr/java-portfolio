package filters;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UsersService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    UsersService usersService;

    public void init(FilterConfig filterConfig) throws ServletException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:context.xml");
        this.usersService = (UsersService)context.getBean("usersService");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        Cookie cookie[] = ((HttpServletRequest) servletRequest).getCookies();
        boolean find = false;
        if (cookie != null){
            for (int i = cookie.length-1; i > 0; i--){
                find = (this.usersService.findUserByToken(cookie[i].getValue()) != null) ? true : false;
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

    public void destroy() {

    }
}
