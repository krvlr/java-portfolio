package ru.kpfu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.dao.FavoriteArtistDao;
import ru.kpfu.model.FavoriteArtist;

import java.util.List;

@Service
public class FavoriteArtistService {

    @Autowired
    FavoriteArtistDao favoriteArtistDao;

    public List<FavoriteArtist> getAllFavoriteArtistData() {
        return favoriteArtistDao.getAllFavoriteArtistData();
    }

}
