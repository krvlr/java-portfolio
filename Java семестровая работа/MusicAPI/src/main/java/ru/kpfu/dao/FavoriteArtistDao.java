package ru.kpfu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.model.FavoriteArtist;
import ru.kpfu.util.ArtistJSONParser;
import ru.kpfu.util.NamesTXTParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FavoriteArtistDao {

    private static String GET_MUSIC_URL = "http://ws.audioscrobbler.com/2.0/?method=artist.getinfo&api_key=541f41538e0e91239c3cc4624119dfd2&format=json&artist=";

    @Autowired
    ArtistJSONParser artistJSONParser;

    @Autowired
    NamesTXTParser namesTXTParser;

    public List<FavoriteArtist> getAllFavoriteArtistData(){

        HttpURLConnection con = null;
        InputStream inputStream = null;
        BufferedReader bufferedReader;

        List<FavoriteArtist> favoriteArtists = new ArrayList<>();

        try {
            for (String name : namesTXTParser.getAllNames()) {
                URL getInfoURL = new URL(GET_MUSIC_URL + name);
                con = (HttpURLConnection) getInfoURL.openConnection();
                con.setRequestMethod("GET");
                con.setDoInput(true);
                con.setDoOutput(true);
                con.connect();

                StringBuffer buffer = new StringBuffer();
                inputStream = con.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = bufferedReader.readLine())!=null){
                    buffer.append(line+"\n");
                }
                inputStream.close();
                bufferedReader.close();
                con.disconnect();

                favoriteArtists.add(artistJSONParser.getArtistInfoFromJSON(buffer.toString()));
            }
            return favoriteArtists;
        }
        catch (Throwable t){
            t.printStackTrace();
        }
        finally {
            try {
                inputStream.close();
            } catch (Throwable t) {
                con.disconnect();
            }
        }
        return null;
    }

}
