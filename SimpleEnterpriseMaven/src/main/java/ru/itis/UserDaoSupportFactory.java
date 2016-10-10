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


    private UserDaoSupportFactory(){
        try {
            properties = new Properties();
            properties.load(
                    new FileInputStream("C:\\Users\\nanob\\Desktop\\JavaWorks\\SimpleEnterpriseMaven\\src\\main\\resources\\res.properties"));

            String daoClass = properties.getProperty("dao.class");
            String serviceClass = properties.getProperty("service.class");

            this.usersDao = (UsersDao)Class.forName(daoClass).getConstructors(String.class).newInstance("C:\\Users\\nanob\\Desktop\\JavaWorks\\SimpleEnterpriseMaven\\users.txt");
            this.usersService = (SimpleUsersService)Class.forName(serviceClass).getConstructors(Class.forName(daoClass).class).newInstance(this.usersDao);
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
    static  {
        instance = new UserDaoSupportFactory();
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
