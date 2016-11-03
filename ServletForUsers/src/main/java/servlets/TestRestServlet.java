package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Car;
import models.CarUser;
import models.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.CarsAndUsersService;
import service.CarsService;
import service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRestServlet extends HttpServlet {

    private UsersService usersService;
    private CarsService carsService;
    private CarsAndUsersService carsAndUsersService;

    ObjectMapper objectMapper = new ObjectMapper();
    Matcher matcher;

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

    private Pattern regAllUserPattern = Pattern.compile("/users");
    private Pattern regUserCarsPattern = Pattern.compile("/users/([0-9]+)/cars");
    private Pattern regAddCarForUserPattern = Pattern.compile("/users/([0-9]+)/addcars");

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String stringResponse = "";

        matcher = regAllUserPattern.matcher(request.getPathInfo());
        if (matcher.find()) {
            String userCity = request.getParameter("city");
            if (userCity == null){
                stringResponse = objectMapper.writeValueAsString(usersService.getAllUser());
            }
            else{
                List<User> allUsers = usersService.getAllUser();
                List<User> usersByCity = new ArrayList<User>();
                for (User user : allUsers) {
                    if (user.getCity().equals(userCity)){
                        usersByCity.add(user);
                    }
                }
                stringResponse = objectMapper.writeValueAsString(usersByCity);
            }
        }

        matcher = regUserCarsPattern.matcher(request.getPathInfo());
        if (matcher.find()) {
            int idUser = Integer.parseInt(matcher.group(1));
            List<CarUser> carsUsers = carsAndUsersService.getAll();
            List<Car> cars = new ArrayList<Car>();
            for (CarUser carUser : carsUsers){
                if (carUser.getIdUser() == idUser){
                    cars.add(carsService.findCarById(carUser.getIdCar()));
                }
            }
            stringResponse = objectMapper.writeValueAsString(cars);
        }

        response.setContentType("application/json");
        response.getWriter().write(stringResponse);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        matcher = regAddCarForUserPattern.matcher(request.getPathInfo());
        if (matcher.find()) {
            String stringRequest = request.getReader().readLine();
            User myUser = objectMapper.readValue(stringRequest, User.class);
            usersService.addUser(myUser);
        }
    }
}
