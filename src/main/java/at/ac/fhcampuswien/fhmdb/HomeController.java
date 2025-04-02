package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.models.MovieAPI;
import at.ac.fhcampuswien.fhmdb.models.SortedState;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class HomeController implements Initializable {
    @FXML
    private JFXButton searchBtn;

    @FXML
    private TextField searchField;

    @FXML
    private JFXListView movieListView;

    @FXML
    private JFXComboBox genreComboBox;

    @FXML
    private JFXButton sortBtn;

    @FXML
    private JFXComboBox releaseYearComboBox;
    @FXML
    private JFXComboBox ratingComboBox;
    public List<Movie> allMovies;
    public List<String> ratings = List.of("0","1", "2", "3", "4", "5", "6", "7", "8", "9","10");


    protected ObservableList<Movie> observableMovies = FXCollections.observableArrayList();
    private final ObservableList<String> observableRating = FXCollections.observableArrayList(ratings);

    protected SortedState sortedState;

    protected MovieAPI movieAPI;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeState();
        initializeLayout();
    }

    public void initializeState() {
        allMovies = Movie.initializeMovies();
        observableMovies.clear();
        observableMovies.addAll(allMovies); // add all movies to the observable list
        sortedState = SortedState.NONE;
        movieAPI = new MovieAPI();


    }

    public void initializeLayout() {
        movieListView.setItems(observableMovies);   // set the items of the listview to the observable list
        movieListView.setCellFactory(movieListView -> new MovieCell()); // apply custom cells to the listview

        Object[] genres = Genre.values();   // get all genres
        genreComboBox.getItems().add("No filter");  // add "no filter" to the combobox
        genreComboBox.getItems().addAll(genres);    // add all genres to the combobox
        genreComboBox.setPromptText("Filter by Genre");

        releaseYearComboBox.setPromptText("Filter by Release Year");
        releaseYearComboBox.getItems().add("No filter");
        releaseYearComboBox.getItems().addAll(getAvailableYears());

        ratingComboBox.setPromptText("Filter by Rating");
        ratingComboBox.getItems().add("No filter");
        ratingComboBox.getItems().addAll(observableRating);
    }

    public List<Integer> getAvailableYears() {
        return allMovies.stream()
                .map(Movie::getReleaseYear)
                .distinct()
                .sorted()
                .toList();
    }

    public void sortMovies(){
        if (sortedState == SortedState.NONE || sortedState == SortedState.DESCENDING) {
            sortMovies(SortedState.ASCENDING);
        } else if (sortedState == SortedState.ASCENDING) {
            sortMovies(SortedState.DESCENDING);
        }
    }


    public void sortMovies(SortedState sortDirection) {
        if (sortDirection == SortedState.ASCENDING) {
            observableMovies.sort(Comparator.comparing(Movie::getTitle));
            sortedState = SortedState.ASCENDING;
        } else {
            observableMovies.sort(Comparator.comparing(Movie::getTitle).reversed());
            sortedState = SortedState.DESCENDING;
        }
    }


    public List<Movie> filterByQuery(List<Movie> movies, String query){
        if(query == null || query.isEmpty()) return movies;

        if(movies == null) {
            throw new IllegalArgumentException("movies must not be null");
        }

        return movies.stream()
                .filter(Objects::nonNull)
                .filter(movie ->
                    movie.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    movie.getDescription().toLowerCase().contains(query.toLowerCase())
                )
                .toList();
    }

    public List<Movie> filterByGenre(List<Movie> movies, Genre genre){
        if(genre == null) return movies;

        if(movies == null) {
            throw new IllegalArgumentException("movies must not be null");
        }

        return movies.stream()
                .filter(Objects::nonNull)
                .filter(movie -> movie.getGenres().contains(genre))
                .toList();
    }

    public void applyAllFilters(String searchQuery, Object genre) {
        List<Movie> filteredMovies = allMovies;

        if (!searchQuery.isEmpty()) {
            filteredMovies = filterByQuery(filteredMovies, searchQuery);
        }

        if (genre != null && !genre.toString().equals("No filter")) {
            filteredMovies = filterByGenre(filteredMovies, Genre.valueOf(genre.toString()));
        }

        observableMovies.clear();
        observableMovies.addAll(filteredMovies);
    }

    public void searchBtnClicked(ActionEvent actionEvent) {
        String searchQuery = searchField.getText().trim().toLowerCase();

        Object genre = genreComboBox.getSelectionModel().getSelectedItem();
        Object year = releaseYearComboBox.getSelectionModel().getSelectedItem();
        Object rating = ratingComboBox.getSelectionModel().getSelectedItem();

        observableMovies.clear();
        observableMovies.addAll(movieAPI.getMovies(
                searchQuery,
                genre != null && !Objects.equals(genre.toString(), "No filter") ? genre.toString() : null,
                year != null && !Objects.equals(year.toString(), "No filter") ? (Integer) year : null,
                rating != null && !Objects.equals(rating.toString(), "No filter") ? Double.parseDouble((String) rating) : null));
        sortMovies(sortedState);
    }

    public void sortBtnClicked(ActionEvent actionEvent) {
        sortMovies();
    }



}