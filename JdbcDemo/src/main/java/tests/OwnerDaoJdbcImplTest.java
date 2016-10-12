package tests;

import dao.OwnerDaoJdbcImpl;
import models.Owner;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class OwnerDaoJdbcImplTest {

    private OwnerDaoJdbcImpl ownerDaoJdbc;
    @Before
    public void setUp() throws Exception {
        ownerDaoJdbc = new OwnerDaoJdbcImpl();
    }

    @Test
    public void getAll() throws Exception {
        List<Owner> owners = ownerDaoJdbc.getAll();
        for(Owner owner : owners){
            System.out.println(owner);
        }
    }

    @Test
    public void find() throws Exception {
        Owner owner = ownerDaoJdbc.find(3);
        System.out.println(owner);
    }

    @Test
    public void add() throws Exception {
        Owner owner = new Owner(11, "Vlad", "Kiselev", new Date(1988,1,1), "Kirov");
        ownerDaoJdbc.add(owner);
    }

    @Test
    public void update() throws Exception {
        Owner owner = new Owner(11, "Vlad", "Kiselev", new Date(1988,1,1), "Kazan");
        ownerDaoJdbc.update(owner);
    }

    @Test
    public void delete() throws Exception {
        ownerDaoJdbc.delete(11);
    }

}