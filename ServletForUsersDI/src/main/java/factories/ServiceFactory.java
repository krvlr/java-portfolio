package factories;

import dao.CarsAndUsersDao;
import dao.CarsDao;
import dao.UsersDao;
import service.CarsAndUsersService;
import service.CarsService;
import service.UsersService;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class ServiceFactory {
    private static ServiceFactory instance;

    private Properties properties;

    private CarsService carsService;
    private UsersService usersService;
    private CarsAndUsersService carsAndUsersService;

    static {
        instance = new ServiceFactory();
    }

    private ServiceFactory() {
        this.properties = new Properties();
        try {
            properties.load(new FileInputStream("C:\\Users\\nanob\\Desktop\\JavaWorks\\ServletForUsers\\src\\main\\resources\\ServiceFactoryProp.properties"));

            String carsServiceClassName = properties.getProperty("carsService.class");
            Constructor constructorCarsService = Class.forName(carsServiceClassName).getConstructor(CarsDao.class);
            this.carsService = (CarsService)constructorCarsService.newInstance(DaoFactory.getInstance().getCarsDao());

            String usersServiceClassName = properties.getProperty("usersService.class");
            Constructor constructorUsersService = Class.forName(usersServiceClassName).getConstructor(UsersDao.class);
            this.usersService = (UsersService)constructorUsersService.newInstance(DaoFactory.getInstance().getUsersDao());

            String carsAndUsersServiceClassName = properties.getProperty("carsAndUsersService.class");
            Constructor constructorCarsAndUsersService = Class.forName(carsAndUsersServiceClassName).getConstructor(CarsAndUsersDao.class);
            this.carsAndUsersService = (CarsAndUsersService)constructorCarsAndUsersService.newInstance(DaoFactory.getInstance().getCarsAndUsersDao());

        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public CarsService getCarsService() {
        return  this.carsService;
    }

    public UsersService getUsersService() {
        return this.usersService;
    }

    public CarsAndUsersService getCarsAndUsersDao() { return  this.carsAndUsersService; }
}
