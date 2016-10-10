package ru.itis;

import ru.itis.dao.UsersDao;
import ru.itis.dao.UsersDaoFileBasedImpl;
import ru.itis.service.SimpleUsersService;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserDaoSupportFactory {

    private static UserDaoSupportFactory instance;

    private Properties properties;

    private UsersDao usersDao;
    private SimpleUsersService usersService;

    static  {
        instance = new UserDaoSupportFactory();
    }

    private UserDaoSupportFactory(){
        try {
            properties = new Properties();
            properties.load(
                    new FileInputStream("C:\\Users\\nanob\\Desktop\\JavaWorks\\SimpleEnterpriseMaven\\src\\main\\resources\\res.properties"));

            String daoClassName = properties.getProperty("dao.class");
            String serviceClassName = properties.getProperty("service.class");

            this.usersDao = (UsersDao)Class.forName(daoClassName).newInstance();
            this.usersService = (SimpleUsersService)Class.forName(serviceClassName).newInstance();
            this.usersService.setUsersDao(this.usersDao);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException();
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException();
        } catch (InstantiationException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public UsersDao getUsersDao() {
        return usersDao;
    }

    public SimpleUsersService getUserService() {
        return usersService;
    }

    public static UserDaoSupportFactory getInstance() {
        return instance;
    }

}
