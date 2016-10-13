package factories;

import dao.CarsDao;
import dao.OwnersDao;
import models.Owner;
import org.postgresql.core.ConnectionFactory;
import service.OwnersService;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.util.Properties;

public class DaoFactory {

    public static DaoFactory instance;

    private CarsDao carsDao;
    private OwnersDao ownersDao;

    private Properties properties;

    static {
        instance = new DaoFactory();
    }

    private DaoFactory(){
        try {
            properties = new Properties();
            properties.load(
                    new FileInputStream("C:\\Users\\nanob\\Desktop\\JavaWorks\\JdbcDemo\\src\\main\\resources\\DaoFactoryProp.properties"));

            String carsDaoClassName = properties.getProperty("carsDao.class");
            String ownersDaoClassName = properties.getProperty("ownersDao.class");

            Constructor carConstructor = Class.forName(carsDaoClassName).getConstructor(Connection.class);
            this.carsDao = (CarsDao)carConstructor.newInstance(JdbcConnection.getInstance().getConnection());

            Constructor ownerConstructor = Class.forName(ownersDaoClassName).getConstructor(Connection.class);
            this.ownersDao = (OwnersDao)ownerConstructor.newInstance(JdbcConnection.getInstance().getConnection());

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

    public OwnersDao getOwnersDao() {
        return ownersDao;
    }

}
