package service;

import models.Owner;

public interface OwnersService {
    Owner findUserById(int id);
    void updateOwner(Owner owner);
}
