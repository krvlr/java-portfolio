package ru.itis.dao;

import com.google.common.base.Splitter;
import ru.itis.models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoFileBasedImpl implements UsersDao {

    private String fileName;
    private BufferedReader fileReader;
    private BufferedWriter fileWriter;
    private PrintWriter out;

    public UsersDaoFileBasedImpl(String fileName) {
        this.fileName = fileName;
    }

    private void openFileForRead(){
        try {
            if (fileWriter != null) {
                fileWriter.close();
            }
            if (fileReader == null){
                fileReader = new BufferedReader(new FileReader(fileName));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private void openFileForWrite(){
        try {
            if (fileReader != null){
                fileReader.close();
            }
            if (fileWriter == null){
                fileWriter = new BufferedWriter(new FileWriter(fileName));
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        out = new PrintWriter(fileWriter);
    }

    @Override
    public List<User> getAll(){
        openFileForRead();
        List<User> result = new ArrayList<>();
        try {
            String currentLine = fileReader.readLine();
            while (currentLine != null) {
                User currentUser = parseStringAsUser(currentLine);
                result.add(currentUser);
                currentLine = fileReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("SomeError: " + e.getMessage());
        }
        return result;
    }

    private User parseStringAsUser(String line) {
        Splitter splitter = Splitter.on(" ");

        List<String> lines = splitter.splitToList(line);

        int id = Integer.parseInt(lines.get(0));
        String name = lines.get(1);
        String password = lines.get(2);
        int age = Integer.parseInt(lines.get(3));

        return new User(id, name, password, age);
    }

    @Override
    public User get(int userId) {
        openFileForRead();
        List<User> allUsers = getAll();
        for (User user : allUsers){
            if (user.getId()==userId){
                return user;
            }
        }
        return null;
    }

    @Override
    public void save(User user) {
        openFileForWrite();
        String writeLine = user.getId() + " " + user.getName() + " " + user.getPassword() + " " + user.getAge();
        out.println(writeLine);
        out.close();
    }

    @Override
    public void delete(int userId) {
        User deletedUser = new User();
        List<User> allUsers = getAll();
        for (User user : allUsers) {
            if (user.getId() == userId) {
                deletedUser = new User(user);
                allUsers.remove(user);
            }
        }
        String deletedLine = deletedUser.getId() + " " + deletedUser.getName() + " " + deletedUser.getPassword() + " " + deletedUser.getAge();
        try {
            String currentLine = fileReader.readLine();
            while (currentLine != null) {
                if(deletedLine.equals(currentLine)) continue;
                fileWriter.write(currentLine + System.getProperty("line.separator"));
                currentLine = fileReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("SomeError" + e.getMessage());
        }
    }
}
