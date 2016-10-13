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

    public void updateOwner(Owner owner) {
        //verifyUserExist(owner.getId());
        this.ownersDao.update(owner);
    }
}
