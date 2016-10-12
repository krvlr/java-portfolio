package dao;

import models.Owner;

import java.util.List;

public interface OwnersDao {
    List<Owner> getAll();

    Owner find(int id);

    void add();

    void update();

    void delete(int id);
}
