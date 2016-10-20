package ru.itis.service;

import ru.itis.dao.OwnersDao;
import ru.itis.models.Owner;

import java.util.List;

import static ru.itis.utils.Verifier.verifyUserExist;

public class OwnersServiceImpl implements OwnersService {

    private OwnersDao ownersDao;

    public OwnersServiceImpl(OwnersDao ownersDao) {
        this.ownersDao = ownersDao;
    }

    public List<Owner> getAllUser() {
        return ownersDao.getAll();
    }

    public Owner findUserById(int id) {
        return ownersDao.find(id);
    }

    @Override
    public void addOwner(Owner owner) {
        ownersDao.add(owner);
    }

    public void updateOwner(Owner owner) {
        this.ownersDao.update(owner);
    }

    @Override
    public void deleteOwner(int id) {
        verifyUserExist(id);
        ownersDao.delete(id);
    }
}
