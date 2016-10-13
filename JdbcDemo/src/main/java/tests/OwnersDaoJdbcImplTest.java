package tests;

import dao.OwnersDaoJdbcImpl;
import factories.JdbcConnection;
import models.Owner;
import org.junit.Before;
import org.junit.Test;
import java.util.GregorianCalendar;
import java.util.List;

public class OwnersDaoJdbcImplTest {

    private OwnersDaoJdbcImpl ownerDaoJdbc;
    @Before
    public void setUp() throws Exception {
        ownerDaoJdbc = new OwnersDaoJdbcImpl(JdbcConnection.getInstance().getConnection());
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
        Owner owner = new Owner(11, "Vlad", "Kiselev", new GregorianCalendar(1986,01,01).getTime(), "Kirov");
        ownerDaoJdbc.add(owner);
    }

    @Test
    public void update() throws Exception {
        Owner owner = new Owner(11, "Vlad", "Kiselev", new GregorianCalendar(1986,01,01).getTime(), "Kazan");
        ownerDaoJdbc.update(owner);
    }

    @Test
    public void delete() throws Exception {
        ownerDaoJdbc.delete(11);
    }

}