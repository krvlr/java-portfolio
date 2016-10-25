package servlets;

import factories.ServiceFactory;
import service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    UsersService usersService;

    @Override
    public void init() throws ServletException {
        super.init();
        usersService = ServiceFactory.getInstance().getUsersService();
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

    }
}
