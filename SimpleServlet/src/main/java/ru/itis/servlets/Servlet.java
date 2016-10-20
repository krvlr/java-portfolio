package ru.itis.servlets;

import ru.itis.factories.ServiceFactory;
import ru.itis.models.Owner;
import ru.itis.service.OwnersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Servlet extends HttpServlet {

    OwnersService ownerService;

    @Override
    public void init() throws ServletException {
        super.init();
        ownerService = ServiceFactory.getInstance().getOwnerService();
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        GregorianCalendar cal = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            cal.setTime(sdf.parse(request.getParameter("dateOfBirth")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ownerService.addOwner(new Owner(11, request.getParameter("firstName"),request.getParameter("lastName"), cal.getTime(),request.getParameter("city")));
        response.setContentType("text/html");
        getServletContext().getRequestDispatcher("/users.jsp").forward(request, response);
    }
}
