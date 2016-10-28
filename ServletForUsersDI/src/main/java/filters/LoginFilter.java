package filters;

import factories.ServiceFactory;
import service.UsersService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LoginFilter implements Filter {
    UsersService usersService;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.usersService = ServiceFactory.getInstance().getUsersService();
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        Cookie cookie[] = ((HttpServletRequest) servletRequest).getCookies();
        if (cookie != null){
            for (int i = cookie.length-1; i > 0; i--){
                if (this.usersService.findUserByToken(cookie[i].getValue()) != null) {
                    filterChain.doFilter(servletRequest, servletResponse);
                    break;
                }
            }
        }
    }

    public void destroy() {

    }
}
