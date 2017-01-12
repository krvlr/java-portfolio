package ru.kpfu.dao;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import org.springframework.stereotype.Repository;
import ru.kpfu.model.User;
import ru.kpfu.model.UserListWrapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@Repository
public class UserDaoXmlImpl implements UserDao {

    private ObservableList<User> userData = null;

    private static final String FILE_PATH = "C:\\Users\\" +
            "nanob\\Desktop\\Задания\\musicVideoTutorial\\Users.xml";

    private File file = new File(FILE_PATH);

    private void loadPersonDataFromFile(File file) {
        try {
            JAXBContext context = JAXBContext.newInstance(UserListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Чтение XML из файла и демаршализация.
            UserListWrapper wrapper = (UserListWrapper) um.unmarshal(file);

            userData.clear();
            userData.addAll(wrapper.getUsers());

        } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not load data");
            alert.setContentText("Could not load data from file:\n" + file.getPath());

            alert.showAndWait();
        }
    }

    private void savePersonDataToFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(UserListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Обёртываем наши данные об адресатах.
            UserListWrapper wrapper = new UserListWrapper();
            wrapper.setUsers(userData);

            // Маршаллируем и сохраняем XML в файл.
            m.marshal(wrapper, file);

        } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file:\n" + file.getPath());

            alert.showAndWait();
        }
    }

    @Override
    public void create(User user) {
        loadPersonDataFromFile(file);
        if (findByNameAndPassword(user.getName(), user.getPassword()) == null) {
            userData.add(user);
        }
        savePersonDataToFile(file);
    }

    @Override
    public void update(User user) {
        for (User us : userData) {
            if (us.getUserId() == user.getUserId()) {
                userData.remove(us);
                userData.add(user);
                savePersonDataToFile(file);
                break;
            }
        }
    }

    @Override
    public void delete(int userId) {
        loadPersonDataFromFile(file);
        for (User us : userData) {
            if (us.getUserId() == userId) {
                userData.remove(us);
                savePersonDataToFile(file);
                break;
            }
        }
    }

    @Override
    public List<User> getAll() {
        loadPersonDataFromFile(file);
        return userData;
    }

    @Override
    public User findByNameAndPassword(String userName, String password) {
        loadPersonDataFromFile(file);
        for (User user : userData) {
            if (user.getName().intern() == userName.intern()
                    && user.getPassword().intern() == password.intern()) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void setToken(int userId, String newToken) {
        loadPersonDataFromFile(file);
        for (User us : userData) {
            if (us.getUserId() == userId) {
                userData.remove(us);
                userData.add(new User(us.getUserId(), us.getName(), us.getPassword(),
                        us.getEmail(), us.getCountry(), us.getSex(), newToken));
                savePersonDataToFile(file);
                break;
            }
        }
    }

    @Override
    public User findByToken(String token) {
        loadPersonDataFromFile(file);
        for (User us : userData) {
            if (us.getToken() == token) {
                return us;
            }
        }
        return null;
    }
}
