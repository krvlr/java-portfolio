package ru.kpfu.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "users")
public class UserListWrapper {

    private List<User> users;

    public UserListWrapper() {
        this.users = new ArrayList<>();
    }

    @XmlElement(name = "user")
    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void removeUser(User user) {
        for (User us : users) {
            if (us.getName().equals(user.getName()) && us.getPassword().equals(user.getPassword())) {
                users.remove(us);
                break;
            }
        }
    }
}