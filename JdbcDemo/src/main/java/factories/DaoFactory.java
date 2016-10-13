package factories;

import dao.CarsDao;
import dao.OwnersDao;
import models.Owner;
import service.OwnersService;

import java.io.FileInputStream;
import java.util.Properties;

public class DaoFactory {

    public static DaoFactory instance;

    private CarsDao carsDao;
    private OwnersDao  ownerDao;

    private Properties properties;

    static {
        instance = new DaoFactory();
    }

    private DaoFactory(){
        try {
            properties = new Properties();
            properties.load(
                    new FileInputStream("C:\\Users\\KFU-user\\Desktop\\JavaWorks\\JdbcDemo\\src\\main\\resources\\DaoFactoryProp.properties"));

            String carsDaoClassName = properties.getProperty("carsDao.class");
            String ownersDaoClassName = properties.getProperty("ownersDao.class");

            this.carsDao = (CarsDao)Class.forName(carsDaoClassName).newInstance();
            this.ownerDao = (OwnersDao)Class.forName(ownersDaoClassName).newInstance();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static DaoFactory getInstance(){
        return instance;
    }

    public CarsDao getCarsDao() {
        return carsDao;
    }

    public OwnersDao getOwnersDao() {
        return ownerDao;
    }

}
