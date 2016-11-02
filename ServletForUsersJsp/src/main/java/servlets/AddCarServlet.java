package servlets;

import models.Car;
import models.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.CarsAndUsersService;
import service.CarsService;
import service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddCarServlet extends HttpServlet {

    private UsersService usersService;
    private CarsService carsService;
    private CarsAndUsersService carsAndUsersService;

    @Override
    public void init() throws ServletException {
        try {
            super.init();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:context.xml");
        usersService = (UsersService)context.getBean("usersService");
        carsService = (CarsService)context.getBean("carsService");
        carsAndUsersService = (CarsAndUsersService)context.getBean("carsAndUsersService");
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/addCar.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie[] = request.getCookies();
        if (cookie != null) {
            for (int i = cookie.length - 1; i > 0; i--) {
                User user = this.usersService.findUserByToken(cookie[i].getValue());
                if (user != null) {
                    Car newCar = new Car(1, request.getParameter("brand"), request.getParameter("model"),
                            Integer.parseInt(request.getParameter("mileage")), request.getParameter("colour"));
                    carsService.addCar(newCar);
                    carsAndUsersService.addCarUser(carsService.findCarByParam(newCar),user);
                    break;
                    }
                }
            }
        response.sendRedirect("/list");
    }
}
