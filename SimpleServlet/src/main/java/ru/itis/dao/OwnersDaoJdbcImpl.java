package ru.itis.dao;

import ru.itis.models.Owner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class OwnersDaoJdbcImpl implements OwnersDao{

    // language=SQL
    public static final String SQL_SELECT_ALL_OWNERS = "SELECT id_owner, first_name, last_name, date_of_birth, city FROM owners;"; //(DATE_PART('year', current_date) - (DATE_PART('year', owners.date_of_birth))) AS ages
    // language=SQL
    public static final String SQL_ADD_OWNER = "INSERT INTO owners(first_name, last_name, date_of_birth, city) VALUES (?, ?, ?::date, ?);";
    // language=SQL
    public static final String SQL_UPDATE_OWNER = "UPDATE owners SET first_name = ?, last_name = ?, date_of_birth = ?::date, city = ? WHERE id_owner = ? ;";
    // language=SQL
    public static final String SQL_DELETE_OWNER = "DELETE FROM owners WHERE id_owner = ?;";

    private Connection connection;
    private Statement statement;

    public OwnersDaoJdbcImpl(Connection connection){
        try{
            this.connection = connection;
            statement = connection.createStatement();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Owner> getAll() {
        List<Owner> allOwners = new ArrayList<Owner>();
        try{
            ResultSet result = statement.executeQuery(SQL_SELECT_ALL_OWNERS);
            while(result.next()) {
                allOwners.add(new Owner(result.getInt("id_owner"), result.getString("first_name"), result.getString("last_name"), result.getDate("date_of_birth"), result.getString("city")));
            }
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
    public void add(Owner owner) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_OWNER);

            preparedStatement.setString(1, owner.getFirstName());
            preparedStatement.setString(2, owner.getLastName());
            preparedStatement.setString(3, new SimpleDateFormat("yyyy-MM-dd").format((owner.getDateOfBirth())));
            preparedStatement.setString(4, owner.getCity());

            preparedStatement.execute();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void update(Owner owner) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_OWNER);

            preparedStatement.setString(1, owner.getFirstName());
            preparedStatement.setString(2, owner.getLastName());
            preparedStatement.setString(3, new SimpleDateFormat("yyyy-MM-dd").format((owner.getDateOfBirth())));
            preparedStatement.setString(4, owner.getCity());
            preparedStatement.setInt(5, owner.getId());

            preparedStatement.execute();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_OWNER);

            preparedStatement.setInt(1, id);

            preparedStatement.execute();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
