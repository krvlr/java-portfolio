package ru.itis.dao;

import com.google.common.base.Splitter;
import ru.itis.models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UsersDaoFileBasedImpl implements UsersDao {

    private BufferedReader fileReader;
    private BufferedWriter fileWriter;
    private String readingFilePath;
    private String writingFilePath;

    public UsersDaoFileBasedImpl() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("C:\\Users\\nanob\\Desktop\\JavaWorks\\SimpleEnterpriseMaven\\src\\main\\resources\\filePath.properties"));
            this.readingFilePath = properties.getProperty("dao.filePathHome") + properties.getProperty("dao.inputFile");
            this.writingFilePath = properties.getProperty("dao.filePathHome") + properties.getProperty("dao.outputFile");
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private void openReadingStream(){
        try {
            this.fileReader = new BufferedReader(new FileReader(this.readingFilePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void openWritingStream(){
        try {
            this.fileWriter = new BufferedWriter(new FileWriter(this.writingFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll(){
        this.openReadingStream();
        List<User> result = new ArrayList<>();
        try {
            String currentLine = this.fileReader.readLine();
            while (currentLine != null) {
                User currentUser = parseStringAsUser(currentLine);
                result.add(currentUser);
                currentLine = this.fileReader.readLine();
            }
            this.fileReader.close();
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
        List<User> allUsers = getAll();
        for (User user : allUsers){
            if (user.getId() == userId){
                return user;
            }
        }
        return null;
    }

    @Override
    public void save(User user) {
        String writeText = "";
        for (User userAll : getAll()){
           writeText += userAll.toString() + System.getProperty("line.separator");
        }
        String writeLine = user.getId() + " " + user.getName() + " " + user.getPassword() + " " + user.getAge();
        writeText += writeLine;
        try {
            openWritingStream();
            this.fileWriter.write(writeText);
            this.fileWriter.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int userId) {
        String writeText = "";
        for (User user : getAll()){
            if (user.getId() != userId){
                writeText += user.toString() + System.getProperty("line.separator");
            }
        }
        this.openWritingStream();
        try {
            this.fileWriter.write(writeText);
            this.fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
