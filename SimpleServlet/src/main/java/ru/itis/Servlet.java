package ru.itis;

import ru.itis.factories.ServiceFactory;
import ru.itis.models.Owner;
import ru.itis.service.OwnersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Servlet extends HttpServlet {
    // метод, реагирующий на http-запрос
    // request - здесь лежит сам запрос
    // response - сюда вы положите ответ
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        OwnersService ownerService = ServiceFactory.getInstance().getOwnerService();
        List<Owner> allOwners = ownerService.getAllUser();
        String message = "All owners\n";
        for (Owner owner: allOwners){
            message += owner.toString();
        }
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }
}
