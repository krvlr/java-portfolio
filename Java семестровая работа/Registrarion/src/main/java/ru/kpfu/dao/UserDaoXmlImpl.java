package ru.kpfu.dao;

import javafx.scene.control.Alert;
import org.springframework.stereotype.Repository;
import ru.kpfu.model.User;
import ru.kpfu.model.UserListWrapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

@Repository
public class UserDaoXmlImpl implements UserDao {

    private UserListWrapper wrapper = new UserListWrapper();

    private static final String FILE_PATH = "C:\\Users\\nanob\\Desktop\\Java Задания" +
            "\\Registrarion\\src\\main\\java\\ru\\kpfu\\Users.xml";

    private File file = new File(FILE_PATH);
    private OutputStream os = null;

    private void loadPersonDataFromFile() {
        try {
            JAXBContext context = JAXBContext.newInstance(UserListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Чтение XML из файла и демаршализация.
            wrapper = (UserListWrapper) um.unmarshal(file);

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not load data");
            alert.setContentText("Could not load data from file:\n" + file.getPath());
            alert.showAndWait();
        }
    }

    private void savePersonDataToFile() {
        try {
            JAXBContext context = JAXBContext.newInstance(UserListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Маршаллируем и сохраняем XML в файл.
            os = new FileOutputStream(file);
            m.marshal(wrapper, os);
            os.close();

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file:\n" + file.getPath());
            alert.showAndWait();
        }
    }

    @Override
    public void create(User user) {
        if (findByNameAndPassword(user.getName(), user.getPassword()) == null) {
            wrapper.addUser(user);
        }
        savePersonDataToFile();
    }

    @Override
    public List<User> getAll() {
        loadPersonDataFromFile();
        return wrapper.getUsers();
    }

    @Override
    public User findByNameAndPassword(String userName, String password) {
        loadPersonDataFromFile();
        for (User user : wrapper.getUsers()) {
            if (user.getName() != null && user.getPassword() != null &&
                    user.getName().equals(userName) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User findByEmail(String email) {
        loadPersonDataFromFile();
        for (User user : wrapper.getUsers()) {
            if (user.getEmail() != null && user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User findByLogin(String login) {
        loadPersonDataFromFile();
        for (User user : wrapper.getUsers()) {
            if (user.getName() != null && user.getName().equals(login)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void setToken(String userName, String newToken) {
        loadPersonDataFromFile();
        for (User us : wrapper.getUsers()) {
            if (us.getName().equals(userName)) {
                wrapper.removeUser(us);
                wrapper.addUser(new User(us.getName(), us.getPassword(), us.getEmail(), us.getCountry(), us.getSex(), newToken));
                savePersonDataToFile();
                break;
            }
        }
    }

    @Override
    public User findByToken(String token) {
        loadPersonDataFromFile();
        for (User us : wrapper.getUsers()) {
            if (us.getToken().equals(token)) {
                return us;
            }
        }
        return null;
    }
}
