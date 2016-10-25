package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LogFilter {
    private String messageParam;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.messageParam = filterConfig.getInitParameter("message-param");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String login = servletRequest.getParameter("login");
        String password = servletRequest.getParameter("password");
        String token = "";
        System.out.println(messageParam + " " + login + " " + password);
        if (login == null & password == null) {
            token = ((HttpServletRequest)servletRequest).getCookies()[0].getValue();
        }

        if (login != null & password != null) {

            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    public void destroy() {

    }
}
