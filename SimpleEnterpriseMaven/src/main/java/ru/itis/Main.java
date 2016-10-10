package ru.itis;

import ru.itis.dao.UsersDao;
import ru.itis.service.SimpleUsersService;

public class Main {

    public static void main(String[] args) {
        UsersDao usersDao =
                UserDaoSupportFactory.getInstance().getUsersDao();

        SimpleUsersService service =
                UserDaoSupportFactory.getInstance().getUserService();

        System.out.println(service.isRegistered("Marsel", "qwerty007"));
    }
}
