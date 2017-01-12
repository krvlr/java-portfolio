package ru.kpfu.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Repository;
import ru.kpfu.model.FavoriteArtist;

@Repository
public class ArtistJSONParser {
    public FavoriteArtist getArtistInfoFromJSON(String jsonLine) {
        String name = "";
        long listeners = 0;
        long playcount = 0;
        String image = "";
        try {
            JSONObject artistAllJsonObject = (JSONObject) JSONValue.parseWithException(jsonLine);
            JSONObject artistJsonObject = (JSONObject) artistAllJsonObject.get("artist");
            name = artistJsonObject.get("name").toString();
            JSONArray imageArray = (JSONArray) artistJsonObject.get("image");
            JSONObject imageData = (JSONObject) imageArray.get(1);
            image = imageData.get("#text").toString();
            JSONObject statsJsonObject = (JSONObject) artistJsonObject.get("stats");
            listeners = Long.parseLong(statsJsonObject.get("listeners").toString());
            playcount = Long.parseLong(statsJsonObject.get("playcount").toString());
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        return new FavoriteArtist(name, listeners, playcount, image);
    }
}
