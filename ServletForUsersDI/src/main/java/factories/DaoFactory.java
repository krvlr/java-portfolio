package factories;

import dao.CarsAndUsersDao;
import dao.CarsDao;
import dao.UsersDao;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.util.Properties;

public class DaoFactory {

    public static DaoFactory instance;

    private CarsDao carsDao;
    private UsersDao usersDao;
    private CarsAndUsersDao carsAndUsersDao;

    private Properties properties;

    static {
        instance = new DaoFactory();
    }

    private DaoFactory(){
        try {
            properties = new Properties();
            properties.load(
                    new FileInputStream("C:\\Users\\nanob\\Desktop\\JavaWorks\\ServletForUsers\\src\\main\\resources\\DaoFactoryProp.properties"));

            String carsDaoClassName = properties.getProperty("carsDao.class");
            String usersDaoClassName = properties.getProperty("usersDao.class");
            String carsAndUsersDaoClassName = properties.getProperty("carsAndUsersDao.class");

            Constructor carConstructor = Class.forName(carsDaoClassName).getConstructor(Connection.class);
            this.carsDao = (CarsDao)carConstructor.newInstance(JdbcConnection.getInstance().getConnection());

            Constructor userConstructor = Class.forName(usersDaoClassName).getConstructor(Connection.class);
            this.usersDao = (UsersDao)userConstructor.newInstance(JdbcConnection.getInstance().getConnection());

            Constructor carsAndUsersConstructor = Class.forName(carsAndUsersDaoClassName).getConstructor(Connection.class);
            this.carsAndUsersDao = (CarsAndUsersDao)carsAndUsersConstructor.newInstance(JdbcConnection.getInstance().getConnection());

        }catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }

    public static DaoFactory getInstance(){
        return instance;
    }

    public CarsDao getCarsDao() {
        return carsDao;
    }

    public UsersDao getUsersDao() {
        return usersDao;
    }

    public CarsAndUsersDao getCarsAndUsersDao(){ return  carsAndUsersDao;}

}
