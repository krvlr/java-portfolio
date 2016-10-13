package service;

import models.Owner;

public interface OwnersService {
    Owner findUserById(int id);
    void addOwner(Owner owner);
    void updateOwner(Owner owner);
    void deleteOwner(int id);
}
