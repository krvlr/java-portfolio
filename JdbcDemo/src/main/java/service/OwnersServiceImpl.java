package service;

import dao.OwnersDao;
import models.Owner;

public class OwnersServiceImpl implements OwnersService {

    private OwnersDao ownersDao;

    public OwnersServiceImpl(OwnersDao ownersDao) {
        this.ownersDao = ownersDao;
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
        ownersDao.delete(id);
    }
}
