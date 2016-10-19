package ru.itis.service;

import ru.itis.models.Owner;

import java.util.List;

public interface OwnersService {
    List<Owner> getAllUser();
    Owner findUserById(int id);
    void addOwner(Owner owner);
    void updateOwner(Owner owner);
    void deleteOwner(int id);
}
