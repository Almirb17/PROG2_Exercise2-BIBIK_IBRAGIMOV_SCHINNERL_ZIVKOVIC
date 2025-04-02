package at.ac.fhcampuswien.fhmdb.models;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class MovieAPI {
    private static final String BASE_URL = "https://prog2.fh-campuswien.ac.at/movies";

    public String buildUrl(String userInput, String genre, Integer releaseYear, Double ratingFrom) {
        StringBuilder urlBuilder = new StringBuilder(BASE_URL);

        if (userInput != null || genre != null || releaseYear != null || ratingFrom != null) {
            urlBuilder.append("?");
            boolean firstParam = true;

            if (userInput != null) {
                urlBuilder.append("query=").append(userInput);
                firstParam = false;
            }
            if (genre != null) {
                if (!firstParam) {
                    urlBuilder.append("&");
                }
                urlBuilder.append("genre=").append(genre);
                firstParam = false;
            }
            if (releaseYear != null) {
                if (!firstParam) {
                    urlBuilder.append("&");
                }
                urlBuilder.append("releaseYear=").append(releaseYear);
                firstParam = false;
            }
            if (ratingFrom != null) {
                if (!firstParam) {
                    urlBuilder.append("&");
                }
                urlBuilder.append("ratingFrom=").append(ratingFrom);
            }
        }

        return urlBuilder.toString();
    }
}