package dao;

import models.Owner;

import java.util.ArrayList;
import java.util.List;

public class OwnerDaoJdbcImpl implements OwnersDao{

    // language=SQL
    public static final String SQL_SELECT_ALL_OWNERS = "SELECT * FROM owners;";
    // language=SQL
    public static final String SQL_ADD_OWNER = "INSERT INTO owners(first_name, last_name, date_of_birth, city) VALUES (?, ?, ?, ?)";
    // language=SQL
    public static final String SQL_UPDATE_OWNER = "";
    // language=SQL
    public static final String SQL_DELETE_OWNER = "";

    @Override
    public List<Owner> getAll() {
        List<Owner> allOwners = new ArrayList<Owner>();
        try{

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return allOwners;
    }

    @Override
    public Owner find(int id) {
        for(Owner owner : getAll()){
            if (owner.getId() == id){
                return owner;
            }
        }
        return null;
    }

    @Override
    public void add() {
        try{

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void update() {
        try{

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try{

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
