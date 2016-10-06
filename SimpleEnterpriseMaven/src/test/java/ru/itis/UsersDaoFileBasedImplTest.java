package ru.itis;

import org.junit.Before;
import org.junit.Test;
import ru.itis.dao.UsersDaoFileBasedImpl;
import ru.itis.models.User;

import java.util.List;

import static org.junit.Assert.*;

public class UsersDaoFileBasedImplTest {

    int ID_TESTED_USER = 2;

    private UsersDaoFileBasedImpl usersDao;

    @Before
    public void setUp() throws Exception {
        usersDao = new UsersDaoFileBasedImpl("C:\\Users\\nanob\\Desktop\\JavaWorks\\SimpleEnterpriseMaven\\users.txt");
    }

    @Test
    public void getAll() throws Exception {
        List<User> registeredUsers = usersDao.getAll();
    }

    @Test
    public void get() throws Exception{
        User expected = new User(2, "Salavat", "qwerty008", 20);
        User actual = usersDao.get(ID_TESTED_USER);
        if(actual.equals(expected)){
            System.out.println("get test sucsess!");
        }else{
            System.out.println("get test fail!");
        }
    }

    @Test
    public void save() throws Exception{
        usersDao.save(new User(4, "Sergey", "qwerty8", 20));
    }

    @Test
    public void delete() throws Exception{

    }

}