package factories;

import dao.CarsDao;
import dao.OwnersDao;
import service.CarsService;
import service.OwnersService;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class ServiceFactory {
    private static ServiceFactory instance;

    private Properties properties;

    private CarsService carsService;
    private OwnersService ownersService;

    static {
        instance = new ServiceFactory();
    }

    private ServiceFactory() {
        this.properties = new Properties();
        try {
            properties.load(new FileInputStream("C:\\Users\\nanob\\Desktop\\JavaWorks\\JdbcDemo\\src\\main\\resources\\ServiceFactoryProp.properties"));

            String carsServiceClassName = properties.getProperty("carsService.class");
            Constructor constructorCarsService = Class.forName(carsServiceClassName).getConstructor(CarsDao.class);
            this.carsService = (CarsService)constructorCarsService.newInstance(DaoFactory.getInstance().getCarsDao());

            String ownersServiceClassName = properties.getProperty("ownersService.class");
            Constructor constructorOwnersService = Class.forName(ownersServiceClassName).getConstructor(OwnersDao.class);
            this.ownersService = (OwnersService)constructorOwnersService.newInstance(DaoFactory.getInstance().getOwnersDao());

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

    public OwnersService getOwnerService() {
        return this.ownersService;
    }
}
