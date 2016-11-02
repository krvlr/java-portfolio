package servlets;

import factories.ServiceFactory;
import models.User;
import service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    UsersService usersService;

    @Override
    public void init() throws ServletException {
        try {
            super.init();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        usersService = ServiceFactory.getInstance().getUsersService();
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String token = null;

        User user = this.usersService.findUserByLoginAndPassword(login, password);
        if (user != null){
            token = usersService.setToken(user);
            request.setAttribute("token", token);
        }

        Cookie tokenCookie = new Cookie("token", token);
        tokenCookie.setMaxAge(600);
        response.addCookie(tokenCookie);

        if (token != null) {
            response.sendRedirect("/list");
        } else {
            response.sendRedirect("/login");
        }
    }
}
