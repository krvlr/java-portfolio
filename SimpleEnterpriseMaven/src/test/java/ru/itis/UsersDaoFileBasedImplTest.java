package ru.itis;

import org.junit.Before;
import org.junit.Test;
import ru.itis.dao.UsersDaoFileBasedImpl;
import ru.itis.models.User;

import java.util.List;

import static org.junit.Assert.*;

public class UsersDaoFileBasedImplTest {

    private UsersDaoFileBasedImpl usersDao;

    @Before
    public void setUp() throws Exception {
        usersDao = new UsersDaoFileBasedImpl("C:\\Users\\KFU-user\\Desktop\\JavaWorks\\SimpleEnterpriseMaven\\users.txt");
    }

    @Test
    public void getAll() throws Exception {
        List<User> registeredUsers = usersDao.getAll();
    }

    @Test
    public void get() throws Exception{
        User expected = new User(2, "Salavat", "qwerty008", 20);
        User actual = usersDao.get(2);
        if(actual.equals(expected)){
            System.out.println("get test sucsess!");
        }else{
            System.out.println("get test fail!");
        }
    }

    @Test
    public void save() throws Exception{
        User expected = new User(4, "Sergey", "qwerty8", 20);
        usersDao.save(expected);
        User actual = usersDao.get(4);
        if(actual.equals(expected)){
            System.out.println("save test sucsess!");
        }else{
            System.out.println("save test fail!");
        }
    }

    @Test
    public void delete() throws Exception{
        usersDao.delete(1);
    }

}