package servlets;

import models.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class RegistrationServlet extends HttpServlet {
    UsersService usersService;

    @Override
    public void init() throws ServletException {
        try {
            super.init();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:context.xml");
        usersService = (UsersService)context.getBean("usersService");
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        GregorianCalendar cal = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            cal.setTime(sdf.parse(request.getParameter("dateOfBirth")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.usersService.addUser(new User(1, request.getParameter("firstName"), request.getParameter("lastName"),
                cal.getTime(), request.getParameter("city"), request.getParameter("login"), request.getParameter("password"), "NULL"));
        response.sendRedirect("/login");
    }
}
