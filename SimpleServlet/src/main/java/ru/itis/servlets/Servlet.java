package ru.itis.servlets;

import ru.itis.factories.ServiceFactory;
import ru.itis.models.Owner;
import ru.itis.service.OwnersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

public class Servlet extends HttpServlet {

    OwnersService ownerService;

    @Override
    public void init() throws ServletException {
        super.init();
        ownerService = ServiceFactory.getInstance().getOwnerService();
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=windows-1251");

        List<Owner> allOwners = ownerService.getAllUser();
        request.setAttribute("allOwners", allOwners);
        getServletContext().getRequestDispatcher("/users.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String city = request.getParameter("city");

        GregorianCalendar cal = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            cal.setTime(sdf.parse(request.getParameter("dateOfBirth")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Owner owner = new Owner(11, firstName, lastName, cal.getTime(), city);
        ownerService.addOwner(owner);

        if (owner != null) {
            request.getSession().setAttribute("allOwners", owner);
            response.sendRedirect("users");
        }
        else {
            request.setAttribute("error", "Unknown user, please try again");
            request.getRequestDispatcher("/users.jsp").forward(request, response);
        }
    }
}
