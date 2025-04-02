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

    public List<Movie> getMovies(String userInput, String genre, Integer releaseYear, Double ratingFrom) {
        try {
            String urlString = buildUrl(userInput, genre, releaseYear, ratingFrom);
            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // JSON-Parsing mit Gson
                Gson gson = new Gson();
                Type movieListType = new TypeToken<List<Movie>>() {
                }.getType();
                return gson.fromJson(response.toString(), movieListType);
            } else {
                System.out.println("Error: Unable to fetch movies. Response code: " + responseCode);
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}