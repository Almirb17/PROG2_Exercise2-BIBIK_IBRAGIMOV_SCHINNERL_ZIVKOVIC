package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.models.SortedState;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {
    private static HomeController homeController;
    @BeforeAll
    static void init() {
        homeController = new HomeController();
    }

    @Test
    void at_initialization_allMovies_and_observableMovies_should_be_filled_and_equal() {
        homeController.initializeState();
        assertEquals(homeController.allMovies, homeController.observableMovies);
    }

    @Test
    void if_not_yet_sorted_sort_is_applied_in_ascending_order() {
        // given
        homeController.initializeState();
        homeController.sortedState = SortedState.NONE;

        // when
        homeController.sortMovies();

        // then
        List<Movie> expected = Arrays.asList(
                new Movie(
                        "Avatar",
                        "A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.",
                        Arrays.asList(Genre.ANIMATION, Genre.DRAMA, Genre.ACTION)),
                new Movie(
                        "Life Is Beautiful",
                        "When an open-minded Jewish librarian and his son become victims of the Holocaust, he uses a perfect mixture of will, humor, and imagination to protect his son from the dangers around their camp." ,
                        Arrays.asList(Genre.DRAMA, Genre.ROMANCE)),
                new Movie(
                        "Puss in Boots",
                        "An outlaw cat, his childhood egg-friend, and a seductive thief kitty set out in search for the eggs of the fabled Golden Goose to clear his name, restore his lost honor, and regain the trust of his mother and town.",
                        Arrays.asList(Genre.COMEDY, Genre.FAMILY, Genre.ANIMATION)),
                new Movie(
                        "The Usual Suspects",
                        "A sole survivor tells of the twisty events leading up to a horrific gun battle on a boat, which begin when five criminals meet at a seemingly random police lineup.",
                        Arrays.asList(Genre.CRIME, Genre.DRAMA, Genre.MYSTERY)),
                new Movie(
                        "The Wolf of Wall Street",
                        "Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.",
                        Arrays.asList(Genre.DRAMA, Genre.ROMANCE, Genre.BIOGRAPHY))

        );

        assertEquals(expected, homeController.observableMovies);

    }

    @Test
    void if_last_sort_ascending_next_sort_should_be_descending() {
        // given
        homeController.initializeState();
        homeController.sortedState = SortedState.ASCENDING;

        // when
        homeController.sortMovies();

        // then
        List<Movie> expected = Arrays.asList(new Movie("ccf4989e-e85b-4119-a113-7ca5298a1b17", // ID
                        "Toy Story", // Title
                        "A cowboy doll is profoundly threatened and jealous when a new spaceman action figure supplants him as top toy in a boy's bedroom.", // Description
                        Arrays.asList(Genre.ANIMATION, Genre.ADVENTURE, Genre.COMEDY, Genre.FAMILY, Genre.FANTASY), // Genres
                        1995, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BMDU2ZWJlMjktMTRhMy00ZTA5LWEzNDgtYmNmZTEwZTViZWJkXkEyXkFqcGdeQXVyNDQ2OTk4MzI@._V1_.jpg", // Image URL
                        81, // Length in minutes
                        Arrays.asList("John Lasseter"), // Directors
                        Arrays.asList("John Lasseter", "Pete Docter", "Andrew Stanton"), // Writers
                        Arrays.asList("Tom Hanks", "Tim Allen", "Don Rickles"), // Main Cast
                        8.3 // Rating
                ),

                new Movie("d95d6912-b281-4e08-86b8-f9101f5f2c15", // ID
                        "The Wolf of Wall Street", // Title
                        "Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.", // Description
                        Arrays.asList(Genre.BIOGRAPHY, Genre.COMEDY, Genre.CRIME, Genre.DRAMA), // Genres
                        2013, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BMjIxMjgxNTk0MF5BMl5BanBnXkFtZTgwNjIyOTg2MDE@._V1_FMjpg_UX1000_.jpg", // Image URL
                        180, // Length in minutes
                        Arrays.asList("Martin Scorsese"), // Directors
                        Arrays.asList("Terence Winter"), // Writers
                        Arrays.asList("Leonardo DiCaprio", "Jonah Hill", "Margot Robbie"), // Main Cast
                        8.2), new Movie("4e66285f-5949-416e-afa8-716e0c3ef46c", // ID
                        "The Usual Suspects", // Title
                        "A sole survivor tells of the twisty events leading up to a horrific gun battle on a boat, which begin when five criminals meet at a seemingly random police lineup.", // Description
                        Arrays.asList(Genre.CRIME, Genre.MYSTERY, Genre.THRILLER), // Genres
                        1995, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BYTViNjMyNmUtNDFkNC00ZDRlLThmMDUtZDU2YWE4NGI2ZjVmXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UX1000_.jpg", // Image URL
                        106, // Length in minutes
                        Arrays.asList("Bryan Singer"), // Directors
                        Arrays.asList("Christopher McQuarrie"), // Writers
                        Arrays.asList("Kevin Spacey", "Gabriel Byrne", "Chazz Palminteri"), // Main Cast
                        8.6 // Rating
                ),

                new Movie("1376dad0-10d4-499c-843a-cb05908b7b35", // ID
                        "The Silence of the Lambs", // Title
                        "A young FBI cadet must receive the help of an incarcerated and manipulative cannibal killer to help catch another serial killer, a madman who skins his victims.", // Description
                        Arrays.asList(Genre.CRIME, Genre.DRAMA, Genre.THRILLER), // Genres
                        1991, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BNjNhZTk0ZmEtNjJhMi00YzFlLWE1MmEtYzM1M2ZmMGMwMTU4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UX1000_.jpg", // Image URL
                        118, // Length in minutes
                        Arrays.asList("Jonathan Demme"), // Directors
                        Arrays.asList("Thomas Harris", "Ted Tally"), // Writers
                        Arrays.asList("Jodie Foster", "Anthony Hopkins", "Scott Glenn"), // Main Cast
                        8.6 // Rating
                ),

                new Movie("dc099995-3b61-44ce-b817-b029b33a1ce1", // ID
                        "The Shawshank Redemption", // Title
                        "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.", // Description
                        Arrays.asList(Genre.DRAMA), // Genres
                        1994, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BNDE3ODcxYzMtY2YzZC00NmNlLWJiNDMtZDViZWM2MzIxZDYwXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_.jpg", // Image URL
                        142, // Length in minutes
                        Arrays.asList("Frank Darabont"), // Directors
                        Arrays.asList("Stephen King", "Frank Darabont"), // Writers
                        Arrays.asList("Tim Robbins", "Morgan Freeman", "Bob Gunton"), // Main Cast
                        9.3 // Rating
                ),

                new Movie("e2d9913d-3869-454c-9fbf-a63aaf57bedf", // ID
                        "The Matrix", // Title
                        "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.", // Description
                        Arrays.asList(Genre.ACTION, Genre.SCIENCE_FICTION), // Genres
                        1999, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UX1000_.jpg", // Image URL
                        136, // Length in minutes
                        Arrays.asList("Lana Wachowski", "Lilly Wachowski"), // Directors
                        Arrays.asList("Lana Wachowski", "Lilly Wachowski"), // Writers
                        Arrays.asList("Keanu Reeves", "Laurence Fishburne", "Carrie-Anne Moss"), // Main Cast
                        8.7 // Rating
                ), new Movie("fff085ba-1b76-4623-9c77-396017ed1e57", // ID
                        "The Lord of the Rings: The Two Towers", // Title
                        "While Frodo and Sam edge closer to Mordor with the help of the shifty Gollum, the divided fellowship makes a stand against Sauron\"s new ally, Saruman, and his hordes of Isengard.", // Description
                        Arrays.asList(Genre.ADVENTURE, Genre.DRAMA, Genre.FANTASY), // Genres
                        2002, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BZTUxNzg3MDUtYjdmZi00ZDY1LTkyYTgtODlmOGY5N2RjYWUyXkEyXkFqcGdeQXVyMTA0MTM5NjI2._V1_FMjpg_UX1000_.jpg", // Image URL
                        179, // Length in minutes
                        Arrays.asList("Peter Jackson"), // Directors
                        Arrays.asList("J.R.R. Tolkien", "Fran Walsh", "Philippa Boyens"), // Writers
                        Arrays.asList("Elijah Wood", "Ian McKellen", "Viggo Mortensen"), // Main Cast
                        8.7 // Rating
                ),

                new Movie("57803b54-5ab7-4c66-a994-0884bcd92b04", // ID
                        "The Lord of the Rings: The Return of the King", // Title
                        "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.", // Description
                        Arrays.asList(Genre.ADVENTURE, Genre.DRAMA, Genre.FANTASY), // Genres
                        2003, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BNzA5ZDNlZWMtM2NhNS00NDJjLTk4NDItYTRmY2EwMWZlMTY3XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UX1000_.jpg", // Image URL
                        201, // Length in minutes
                        Arrays.asList("Peter Jackson"), // Directors
                        Arrays.asList("J.R.R. Tolkien", "Fran Walsh", "Philippa Boyens"), // Writers
                        Arrays.asList("Elijah Wood", "Ian McKellen", "Viggo Mortensen"), // Main Cast
                        8.9 // Rating
                ),

                new Movie("6d7a6581-665e-4f55-b323-094358849312", // ID
                        "The Lion King", // Title
                        "Lion cub and future king Simba searches for his identity. His eagerness to please others and penchant for testing his boundaries sometimes gets him into trouble.", // Description
                        Arrays.asList(Genre.ANIMATION, Genre.ADVENTURE, Genre.DRAMA, Genre.FAMILY, Genre.MUSICAL), // Genres
                        1994, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BMjIwMjE1Nzc4NV5BMl5BanBnXkFtZTgwNDg4OTA1NzM@._V1_FMjpg_UX1000_.jpg", // Image URL
                        88, // Length in minutes
                        Arrays.asList("Roger Allers", "Rob Minkoff"), // Directors
                        Arrays.asList("Irene Mecchi", "Jonathan Roberts", "Linda Woolverton"), // Writers
                        Arrays.asList("Matthew Broderick", "Jeremy Irons", "James Earl Jones"), // Main Cast
                        8.5 // Rating
                ),

                new Movie("8d47a927-7e9c-4b67-ba51-790a55f6985b", // ID
                        "The Good, the Bad and the Ugly", // Title
                        "A bounty hunting scam joins two men in an uneasy alliance against a third in a race to find a fortune in gold buried in a remote cemetery.", // Description
                        Arrays.asList(Genre.WESTERN), // Genres
                        1966, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BNjJlYmNkZGItM2NhYy00MjlmLTk5NmQtNjg1NmM2ODU4OTMwXkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_FMjpg_UX1000_.jpg", // Image URL
                        161, // Length in minutes
                        Arrays.asList("Sergio Leone"), // Directors
                        Arrays.asList("Luciano Vincenzoni", "Agenore Incrocci", "Furio Scarpelli", "Sergio Leone"), // Writers
                        Arrays.asList("Clint Eastwood", "Eli Wallach", "Lee Van Cleef"), // Main Cast
                        8.9 // Rating
                ),

                new Movie("81d317b0-29e5-4846-97a6-43c07f3edf4a", // ID
                        "The Godfather", // Title
                        "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.", // Description
                        Arrays.asList(Genre.DRAMA), // Genres
                        1972, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg", // Image URL
                        175, // Length in minutes
                        Arrays.asList("Francis Ford Coppola"), // Directors
                        Arrays.asList("Mario Puzo", "Francis Ford Coppola"), // Writers
                        Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"), // Main Cast
                        9.2 // Rating
                ),

                new Movie("70638b3c-8a1e-414a-9a53-05ebf64078a2", // ID
                        "The Dark Knight", // Title
                        "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, the caped crusader must come to terms with one of the greatest psychological tests of his ability to fight injustice.", // Description
                        Arrays.asList(Genre.ACTION, Genre.CRIME, Genre.DRAMA), // Genres
                        2008, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BMTk4ODQzNDY3Ml5BMl5BanBnXkFtZTcwODA0NTM4Nw@@._V1_FMjpg_UX1000_.jpg", // Image URL
                        152, // Length in minutes
                        Arrays.asList("Christopher Nolan"), // Directors
                        Arrays.asList("Jonathan Nolan", "Christopher Nolan"), // Writers
                        Arrays.asList("Christian Bale", "Heath Ledger", "Aaron Eckhart"), // Main Cast
                        9.0 // Rating
                ),

                new Movie("a45e4b03-ece7-49e7-8144-4f2a6fe03432", // ID
                        "Star Wars: Episode V - The Empire Strikes Back", // Title
                        "After the rebels are brutally overpowered by the Empire on the ice planet Hoth, Luke Skywalker begins Jedi training with Yoda, while his friends are pursued by Darth Vader and a bounty hunter named Boba Fett all over the galaxy.", // Description
                        Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY, Genre.SCIENCE_FICTION), // Genres
                        1980, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BYmU1NDRjNDgtMzhiMi00NjZmLTg5NGItZDNiZjU5NTU4OTE0XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg", // Image URL
                        124, // Length in minutes
                        Arrays.asList("Irvin Kershner"), // Directors
                        Arrays.asList("Leigh Brackett", "Lawrence Kasdan", "George Lucas"), // Writers
                        Arrays.asList("Mark Hamill", "Harrison Ford", "Carrie Fisher"), // Main Cast
                        8.7 // Rating
                ),

                new Movie("3588776d-a182-4de8-9e05-5157b40191df", // ID
                        "Spirited Away", // Title
                        "During her family's move to the suburbs, a sullen 10-year-old girl wanders into a world ruled by gods, witches, and spirits, and where humans are changed into beasts.", // Description
                        Arrays.asList(Genre.ANIMATION, Genre.ADVENTURE, Genre.FAMILY, Genre.FANTASY, Genre.MYSTERY), // Genres
                        2001, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BMjlmZmI5MDctNDE2YS00YWE0LWE5ZWItZDBhYWQ0NTcxNWRhXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_FMjpg_UX1000_.jpg", // Image URL
                        125, // Length in minutes
                        Arrays.asList("Hayao Miyazaki"), // Directors
                        Arrays.asList("Hayao Miyazaki"), // Writers
                        Arrays.asList("Daveigh Chase", "Suzanne Pleshette", "Miyu Irino"), // Main Cast
                        8.6 // Rating
                ),

                new Movie("8d948831-a076-4ac0-b939-1cf547a6cf58", // ID
                        "Seven", // Title
                        "Two detectives, a rookie and a veteran, hunt a serial killer who uses the seven deadly sins as his modus operandi.", // Description
                        Arrays.asList(Genre.CRIME, Genre.DRAMA, Genre.MYSTERY, Genre.THRILLER), // Genres
                        1995, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BOTUwODM5MTctZjczMi00OTk4LTg3NWUtNmVhMTAzNTNjYjcyXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UX1000_.jpg", // Image URL
                        127, // Length in minutes
                        Arrays.asList("David Fincher"), // Directors
                        Arrays.asList("Andrew Kevin Walker"), // Writers
                        Arrays.asList("Morgan Freeman", "Brad Pitt", "Kevin Spacey"), // Main Cast
                        8.6 // Rating
                ),

                new Movie("521ba69d-f716-4a3d-a048-39cb05a685b1", // ID
                        "Schindler's List", // Title
                        "In German-occupied Poland during World War II, Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazi Germans.", // Description
                        Arrays.asList(Genre.BIOGRAPHY, Genre.DRAMA, Genre.HISTORY), // Genres
                        1993, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_.jpg", // Image URL
                        195, // Length in minutes
                        Arrays.asList("Steven Spielberg"), // Directors
                        Arrays.asList("Steven Zaillian", "Thomas Keneally"), // Writers
                        Arrays.asList("Liam Neeson", "Ralph Fiennes", "Ben Kingsley"), // Main Cast
                        8.9 // Rating
                ),

                new Movie("9996624f-9627-430a-b763-ed0e6c1a8e1b", // ID
                        "Saving Private Ryan", // Title
                        "Following the Normandy Landings, a group of U.S. soldiers go behind enemy lines to retrieve a paratrooper whose brothers have been killed in action.", // Description
                        Arrays.asList(Genre.ACTION, Genre.DRAMA, Genre.WAR), // Genres
                        1998, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BZjhkMDM4MWItZTVjOC00ZDRhLThmYTAtM2I5NzBmNmNlMzI1XkEyXkFqcGdeQXVyNDYyMDk5MTU@._V1_FMjpg_UX1000_.jpg", // Image URL
                        169, // Length in minutes
                        Arrays.asList("Steven Spielberg"), // Directors
                        Arrays.asList("Robert Rodat"), // Writers
                        Arrays.asList("Tom Hanks", "Matt Damon", "Tom Sizemore"), // Main Cast
                        8.6 // Rating
                ),

                new Movie("a1857686-0eac-474f-befb-fc7cade26a2f", // ID
                        "Puss in Boots", // Title
                        "An outlaw cat, his childhood egg-friend, and a seductive thief kitty set out in search for the eggs of the fabled Golden Goose to clear his name, restore his lost honor, and regain the trust of his mother and town.", // Description
                        Arrays.asList(Genre.ANIMATION, Genre.ADVENTURE, Genre.COMEDY), // Genres
                        2011, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BNjMyMDBjMGUtNDUzZi00N2MwLTg1MjItZTk2MDE1OTZmNTYxXkEyXkFqcGdeQXVyMTQ5NjA0NDM0._V1_FMjpg_UX1000_.jpg", // Image URL
                        90, // Length in minutes
                        Arrays.asList("Chris Miller"), // Directors
                        Arrays.asList("Tom Wheeler", "Brian Lynch"), // Writers
                        Arrays.asList("Antonio Banderas", "Salma Hayek", "Zach Galifianakis"), // Main Cast
                        6.6 // Rating
                ),

                new Movie("7760c868-c4ce-46b9-87ec-8cf2bcf3d0fe", // ID
                        "Pulp Fiction", // Title
                        "The lives of two mob hit men, a boxer, a gangster's wife, and a pair of diner bandits intertwine in four tales of violence and redemption.", // Description
                        Arrays.asList(Genre.CRIME, Genre.DRAMA), // Genres
                        1994, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg", // Image URL
                        154, // Length in minutes
                        Arrays.asList("Quentin Tarantino"), // Directors
                        Arrays.asList("Quentin Tarantino", "Roger Avary"), // Writers
                        Arrays.asList("John Travolta", "Uma Thurman", "Samuel L. Jackson"), // Main Cast
                        8.9 // Rating
                ),

                new Movie("751f6871-f68b-461c-828d-12b1df47af10", // ID
                        "One Flew Over the Cuckoo\"s Nest", // Title
                        "A criminal pleads insanity after getting into trouble again and once in the mental institution rebels against the oppressive nurse and rallies up the scared patients.", // Description
                        Arrays.asList(Genre.DRAMA), // Genres
                        1975, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BZjA0OWVhOTAtYWQxNi00YzNhLWI4ZjYtNjFjZTEyYjJlNDVlL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_.jpg", // Image URL
                        133, // Length in minutes
                        Arrays.asList("Milos Forman"), // Directors
                        Arrays.asList("Lawrence Hauben", "Bo Goldman"), // Writers
                        Arrays.asList("Jack Nicholson", "Louise Fletcher", "William Redfield"), // Main Cast
                        8.7 // Rating
                ),

                new Movie("c2aaf369-4884-4dea-bed5-a912d70045ee", // ID
                        "Once Upon a Time in Hollywood", // Title
                        "A faded television actor and his stunt double strive to achieve fame and success in the film industry during the final years of Hollywood's Golden Age in 1969 Los Angeles.", // Description
                        Arrays.asList(Genre.COMEDY, Genre.DRAMA), // Genres
                        2019, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BOTg4ZTNkZmUtMzNlZi00YmFjLTk1MmUtNWQwNTM0YjcyNTNkXkEyXkFqcGdeQXVyNjg2NjQwMDQ@._V1_UY1200_CR90,0,630,1200_AL_.jpg", // Image URL
                        161, // Length in minutes
                        Arrays.asList("Quentin Tarantino"), // Directors
                        Arrays.asList("Quentin Tarantino"), // Writers
                        Arrays.asList("Leonardo DiCaprio", "Brad Pitt", "Margot Robbie"), // Main Cast
                        7.7 // Rating
                ),

                new Movie("dfc0a8ce-7263-4c6c-9cf3-426df01e823c", // ID
                        "Life Is Beautiful", // Title
                        "When an open-minded Jewish librarian and his son become victims of the Holocaust, he uses a perfect mixture of will, humor, and imagination to protect his son from the dangers around their camp.", // Description
                        Arrays.asList(Genre.COMEDY, Genre.DRAMA, Genre.ROMANCE, Genre.WAR), // Genres
                        1997, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BYmJmM2Q4NmMtYThmNC00ZjRlLWEyZmItZTIwOTBlZDQ3NTQ1XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_FMjpg_UX1000_.jpg", // Image URL
                        116, // Length in minutes
                        Arrays.asList("Roberto Benigni"), // Directors
                        Arrays.asList("Vincenzo Cerami", "Roberto Benigni"), // Writers
                        Arrays.asList("Roberto Benigni", "Nicoletta Braschi", "Giorgio Cantarini"), // Main Cast
                        8.6 // Rating
                ),

                new Movie("fc472f5b-1ac7-4307-bbdf-f9c46cb02d5e", // ID
                        "Knives Out", // Title
                        "A detective investigates the death of a patriarch of an eccentric, combative family.", // Description
                        Arrays.asList(Genre.COMEDY, Genre.CRIME, Genre.DRAMA, Genre.MYSTERY, Genre.THRILLER), // Genres
                        2019, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BMGUwZjliMTAtNzAxZi00MWNiLWE2NzgtZGUxMGQxZjhhNDRiXkEyXkFqcGdeQXVyNjU1NzU3MzE@._V1_.jpg", // Image URL
                        130, // Length in minutes
                        Arrays.asList("Rian Johnson"), // Directors
                        Arrays.asList("Rian Johnson"), // Writers
                        Arrays.asList("Daniel Craig", "Chris Evans", "Ana de Armas"), // Main Cast
                        7.9 // Rating
                ),

                new Movie("5627343a-0bed-4a72-897a-365d2234f571", // ID
                        "It\"s a Wonderful Life", // Title
                        "An angel is sent from Heaven to help a desperately frustrated businessman by showing him what life would have been like if he had never existed.", // Description
                        Arrays.asList(Genre.DRAMA, Genre.FAMILY, Genre.FANTASY), // Genres
                        1946, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BZjc4NDZhZWMtNGEzYS00ZWU2LThlM2ItNTA0YzQ0OTExMTE2XkEyXkFqcGdeQXVyNjUwMzI2NzU@._V1_FMjpg_UX1000_.jpg", // Image URL
                        130, // Length in minutes
                        Arrays.asList("Frank Capra"), // Directors
                        Arrays.asList("Frances Goodrich", "Albert Hackett", "Frank Capra"), // Writers
                        Arrays.asList("James Stewart", "Donna Reed", "Lionel Barrymore"), // Main Cast
                        8.6 // Rating
                ),

                new Movie("86642997-ee66-4102-ade1-54941a1d3a6e", // ID
                        "Inception", // Title
                        "A thief, who steals corporate secrets through use of dream-sharing technology, is given the inverse task of planting an idea into the mind of a CEO.", // Description
                        Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.SCIENCE_FICTION, Genre.THRILLER), // Genres
                        2010, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_FMjpg_UX1000_.jpg", // Image URL
                        148, // Length in minutes
                        Arrays.asList("Christopher Nolan"), // Directors
                        Arrays.asList("Christopher Nolan"), // Writers
                        Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Elliot Page"), // Main Cast
                        8.8 // Rating
                ), new Movie("45acd8b1-e4ed-47eb-b594-42695faebccf", // ID
                        "Goodfellas", // Title
                        "The story of Henry Hill and his life in the mob, covering his relationship with his wife Karen Hill and his mob partners Jimmy Conway and Tommy DeVito in the Italian-American crime syndicate.", // Description
                        Arrays.asList(Genre.BIOGRAPHY, Genre.CRIME, Genre.DRAMA), // Genres
                        1990, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BY2NkZjEzMDgtN2RjYy00YzM1LWI4ZmQtMjIwYjFjNmI3ZGEwXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UX1000_.jpg", // Image URL
                        146, // Length in minutes
                        Arrays.asList("Martin Scorsese"), // Directors
                        Arrays.asList("Nicholas Pileggi", "Nicholas Pileggi"), // Writers
                        Arrays.asList("Robert De Niro", "Ray Liotta", "Joe Pesci"), // Main Cast
                        8.7 // Rating
                ),

                new Movie("2fd4eac6-aba8-4c74-b141-e524cb5ca0a5", // ID
                        "Forrest Gump", // Title
                        "The presidencies of Kennedy and Johnson, the Vietnam War, the Watergate scandal and other historical events unfold from the perspective of an Alabama man with an IQ of 75, whose only desire is to be reunited with his childhood sweetheart.", // Description
                        Arrays.asList(Genre.DRAMA, Genre.ROMANCE), // Genres
                        1994, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BNWIwODRlZTUtY2U3ZS00Yzg1LWJhNzYtMmZiYmEyNmU1NjMzXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_FMjpg_UX1000_.jpg", // Image URL
                        144, // Length in minutes
                        Arrays.asList("Robert Zemeckis"), // Directors
                        Arrays.asList("Eric Roth", "Winston Groom"), // Writers
                        Arrays.asList("Tom Hanks", "Robin Wright", "Gary Sinise"), // Main Cast
                        8.8 // Rating
                ),

                new Movie("da92ef19-3b24-4406-bee4-ddb09d35c389", // ID
                        "Django Unchained", // Title
                        "With the help of a German bounty hunter, a freed slave sets out to rescue his wife from a brutal Mississippi plantation owner.", // Description
                        Arrays.asList(Genre.DRAMA, Genre.WESTERN), // Genres
                        2012, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BMjIyNTQ5NjQ1OV5BMl5BanBnXkFtZTcwODg1MDU4OA@@._V1_UY1200_CR90,0,630,1200_AL_.jpg", // Image URL
                        165, // Length in minutes
                        Arrays.asList("Quentin Tarantino"), // Directors
                        Arrays.asList("Quentin Tarantino"), // Writers
                        Arrays.asList("Jamie Foxx", "Christoph Waltz", "Leonardo DiCaprio"), // Main Cast
                        8.4 // Rating
                ), new Movie("d42ed31e-98a9-4c56-b104-5ae68b9dc970", // ID
                        "City of God", // Title
                        "Two boys growing up in a violent neighborhood of Rio de Janeiro take different paths: one becomes a photographer, the other a drug dealer.", // Description
                        Arrays.asList(Genre.CRIME, Genre.DRAMA), // Genres
                        2002, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BMGU5OWEwZDItNmNkMC00NzZmLTk1YTctNzVhZTJjM2NlZTVmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_FMjpg_UX1000_.jpg", // Image URL
                        130, // Length in minutes
                        Arrays.asList("Fernando Meirelles", "Kátia Lund"), // Directors
                        Arrays.asList("Paulo Lins", "Bráulio Mantovani"), // Writers
                        Arrays.asList("Alexandre Rodrigues", "Matheus Nachtergaele", "Leandro Firmino"), // Main Cast
                        8.6 // Rating
                ), new Movie("c6bfb760-9f95-4966-9f9e-c89a06702bac", // ID
                        "Avatar", // Title
                        "A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.", // Description
                        Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY, Genre.SCIENCE_FICTION), // Genres
                        2009, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BZDA0OGQxNTItMDZkMC00N2UyLTg3MzMtYTJmNjg3Nzk5MzRiXkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_FMjpg_UX1000_.jpg", // Image URL
                        162, // Length in minutes
                        Arrays.asList("James Cameron"), // Directors
                        Arrays.asList("James Cameron"), // Writers
                        Arrays.asList("Sam Worthington", "Zoe Saldana", "Sigourney Weaver"), // Main Cast
                        7.8 // Rating
                ), new Movie("2feb8100-3f96-494c-9ded-eb405f43dbfb", // ID
                        "12 Angry Men", // Title
                        "A jury holdout attempts to prevent a miscarriage of justice by forcing his colleagues to reconsider the evidence.", // Description
                        Arrays.asList(Genre.DRAMA), // Genres
                        1957, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BMWU4N2FjNzYtNTVkNC00NzQ0LTg0MjAtYTJlMjFhNGUxZDFmXkEyXkFqcGdeQXVyNjc1NTYyMjg@._V1_FMjpg_UX1000_.jpg", // Image URL
                        96, // Length in minutes
                        Arrays.asList("Sidney Lumet"), // Directors
                        Arrays.asList("Reginald Rose"), // Writers
                        Arrays.asList("Henry Fonda", "Lee J. Cobb", "Martin Balsam"), // Main Cast
                        8.9 // Rating
                )


        );


        assertEquals(expected, homeController.observableMovies);
    }

    @Test
    void if_last_sort_descending_next_sort_should_be_ascending() {
        // given
        homeController.initializeState();
        homeController.sortedState = SortedState.DESCENDING;

        // when
        homeController.sortMovies();

        // then
        List<Movie> expected = Arrays.asList(new Movie("2feb8100-3f96-494c-9ded-eb405f43dbfb", // ID
                        "12 Angry Men", // Title
                        "A jury holdout attempts to prevent a miscarriage of justice by forcing his colleagues to reconsider the evidence.", // Description
                        Arrays.asList(Genre.DRAMA), // Genres
                        1957, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BMWU4N2FjNzYtNTVkNC00NzQ0LTg0MjAtYTJlMjFhNGUxZDFmXkEyXkFqcGdeQXVyNjc1NTYyMjg@._V1_FMjpg_UX1000_.jpg", // Image URL
                        96, // Length in minutes
                        Arrays.asList("Sidney Lumet"), // Directors
                        Arrays.asList("Reginald Rose"), // Writers
                        Arrays.asList("Henry Fonda", "Lee J. Cobb", "Martin Balsam"), // Main Cast
                        8.9 // Rating
                ),


                new Movie("c6bfb760-9f95-4966-9f9e-c89a06702bac", // ID
                        "Avatar", // Title
                        "A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.", // Description
                        Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY, Genre.SCIENCE_FICTION), // Genres
                        2009, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BZDA0OGQxNTItMDZkMC00N2UyLTg3MzMtYTJmNjg3Nzk5MzRiXkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_FMjpg_UX1000_.jpg", // Image URL
                        162, // Length in minutes
                        Arrays.asList("James Cameron"), // Directors
                        Arrays.asList("James Cameron"), // Writers
                        Arrays.asList("Sam Worthington", "Zoe Saldana", "Sigourney Weaver"), // Main Cast
                        7.8 // Rating
                ),


                new Movie("d42ed31e-98a9-4c56-b104-5ae68b9dc970", // ID
                        "City of God", // Title
                        "Two boys growing up in a violent neighborhood of Rio de Janeiro take different paths: one becomes a photographer, the other a drug dealer.", // Description
                        Arrays.asList(Genre.CRIME, Genre.DRAMA), // Genres
                        2002, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BMGU5OWEwZDItNmNkMC00NzZmLTk1YTctNzVhZTJjM2NlZTVmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_FMjpg_UX1000_.jpg", // Image URL
                        130, // Length in minutes
                        Arrays.asList("Fernando Meirelles", "Kátia Lund"), // Directors
                        Arrays.asList("Paulo Lins", "Bráulio Mantovani"), // Writers
                        Arrays.asList("Alexandre Rodrigues", "Matheus Nachtergaele", "Leandro Firmino"), // Main Cast
                        8.6 // Rating
                ),


                new Movie("da92ef19-3b24-4406-bee4-ddb09d35c389", // ID
                        "Django Unchained", // Title
                        "With the help of a German bounty hunter, a freed slave sets out to rescue his wife from a brutal Mississippi plantation owner.", // Description
                        Arrays.asList(Genre.DRAMA, Genre.WESTERN), // Genres
                        2012, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BMjIyNTQ5NjQ1OV5BMl5BanBnXkFtZTcwODg1MDU4OA@@._V1_UY1200_CR90,0,630,1200_AL_.jpg", // Image URL
                        165, // Length in minutes
                        Arrays.asList("Quentin Tarantino"), // Directors
                        Arrays.asList("Quentin Tarantino"), // Writers
                        Arrays.asList("Jamie Foxx", "Christoph Waltz", "Leonardo DiCaprio"), // Main Cast
                        8.4 // Rating
                ),


                new Movie("2fd4eac6-aba8-4c74-b141-e524cb5ca0a5", // ID
                        "Forrest Gump", // Title
                        "The presidencies of Kennedy and Johnson, the Vietnam War, the Watergate scandal and other historical events unfold from the perspective of an Alabama man with an IQ of 75, whose only desire is to be reunited with his childhood sweetheart.", // Description
                        Arrays.asList(Genre.DRAMA, Genre.ROMANCE), // Genres
                        1994, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BNWIwODRlZTUtY2U3ZS00Yzg1LWJhNzYtMmZiYmEyNmU1NjMzXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_FMjpg_UX1000_.jpg", // Image URL
                        144, // Length in minutes
                        Arrays.asList("Robert Zemeckis"), // Directors
                        Arrays.asList("Eric Roth", "Winston Groom"), // Writers
                        Arrays.asList("Tom Hanks", "Robin Wright", "Gary Sinise"), // Main Cast
                        8.8 // Rating
                ),


                new Movie("45acd8b1-e4ed-47eb-b594-42695faebccf", // ID
                        "Goodfellas", // Title
                        "The story of Henry Hill and his life in the mob, covering his relationship with his wife Karen Hill and his mob partners Jimmy Conway and Tommy DeVito in the Italian-American crime syndicate.", // Description
                        Arrays.asList(Genre.BIOGRAPHY, Genre.CRIME, Genre.DRAMA), // Genres
                        1990, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BY2NkZjEzMDgtN2RjYy00YzM1LWI4ZmQtMjIwYjFjNmI3ZGEwXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UX1000_.jpg", // Image URL
                        146, // Length in minutes
                        Arrays.asList("Martin Scorsese"), // Directors
                        Arrays.asList("Nicholas Pileggi", "Nicholas Pileggi"), // Writers
                        Arrays.asList("Robert De Niro", "Ray Liotta", "Joe Pesci"), // Main Cast
                        8.7 // Rating
                ),


                new Movie("86642997-ee66-4102-ade1-54941a1d3a6e", // ID
                        "Inception", // Title
                        "A thief, who steals corporate secrets through use of dream-sharing technology, is given the inverse task of planting an idea into the mind of a CEO.", // Description
                        Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.SCIENCE_FICTION, Genre.THRILLER), // Genres
                        2010, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_FMjpg_UX1000_.jpg", // Image URL
                        148, // Length in minutes
                        Arrays.asList("Christopher Nolan"), // Directors
                        Arrays.asList("Christopher Nolan"), // Writers
                        Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Elliot Page"), // Main Cast
                        8.8 // Rating
                ),


                new Movie("5627343a-0bed-4a72-897a-365d2234f571", // ID
                        "It\"s a Wonderful Life", // Title
                        "An angel is sent from Heaven to help a desperately frustrated businessman by showing him what life would have been like if he had never existed.", // Description
                        Arrays.asList(Genre.DRAMA, Genre.FAMILY, Genre.FANTASY), // Genres
                        1946, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BZjc4NDZhZWMtNGEzYS00ZWU2LThlM2ItNTA0YzQ0OTExMTE2XkEyXkFqcGdeQXVyNjUwMzI2NzU@._V1_FMjpg_UX1000_.jpg", // Image URL
                        130, // Length in minutes
                        Arrays.asList("Frank Capra"), // Directors
                        Arrays.asList("Frances Goodrich", "Albert Hackett", "Frank Capra"), // Writers
                        Arrays.asList("James Stewart", "Donna Reed", "Lionel Barrymore"), // Main Cast
                        8.6 // Rating
                ),


                new Movie("fc472f5b-1ac7-4307-bbdf-f9c46cb02d5e", // ID
                        "Knives Out", // Title
                        "A detective investigates the death of a patriarch of an eccentric, combative family.", // Description
                        Arrays.asList(Genre.COMEDY, Genre.CRIME, Genre.DRAMA, Genre.MYSTERY, Genre.THRILLER), // Genres
                        2019, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BMGUwZjliMTAtNzAxZi00MWNiLWE2NzgtZGUxMGQxZjhhNDRiXkEyXkFqcGdeQXVyNjU1NzU3MzE@._V1_.jpg", // Image URL
                        130, // Length in minutes
                        Arrays.asList("Rian Johnson"), // Directors
                        Arrays.asList("Rian Johnson"), // Writers
                        Arrays.asList("Daniel Craig", "Chris Evans", "Ana de Armas"), // Main Cast
                        7.9 // Rating
                ),


                new Movie("dfc0a8ce-7263-4c6c-9cf3-426df01e823c", // ID
                        "Life Is Beautiful", // Title
                        "When an open-minded Jewish librarian and his son become victims of the Holocaust, he uses a perfect mixture of will, humor, and imagination to protect his son from the dangers around their camp.", // Description
                        Arrays.asList(Genre.COMEDY, Genre.DRAMA, Genre.ROMANCE, Genre.WAR), // Genres
                        1997, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BYmJmM2Q4NmMtYThmNC00ZjRlLWEyZmItZTIwOTBlZDQ3NTQ1XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_FMjpg_UX1000_.jpg", // Image URL
                        116, // Length in minutes
                        Arrays.asList("Roberto Benigni"), // Directors
                        Arrays.asList("Vincenzo Cerami", "Roberto Benigni"), // Writers
                        Arrays.asList("Roberto Benigni", "Nicoletta Braschi", "Giorgio Cantarini"), // Main Cast
                        8.6 // Rating
                ),

                new Movie("c2aaf369-4884-4dea-bed5-a912d70045ee", // ID
                        "Once Upon a Time in Hollywood", // Title
                        "A faded television actor and his stunt double strive to achieve fame and success in the film industry during the final years of Hollywood's Golden Age in 1969 Los Angeles.", // Description
                        Arrays.asList(Genre.COMEDY, Genre.DRAMA), // Genres
                        2019, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BOTg4ZTNkZmUtMzNlZi00YmFjLTk1MmUtNWQwNTM0YjcyNTNkXkEyXkFqcGdeQXVyNjg2NjQwMDQ@._V1_UY1200_CR90,0,630,1200_AL_.jpg", // Image URL
                        161, // Length in minutes
                        Arrays.asList("Quentin Tarantino"), // Directors
                        Arrays.asList("Quentin Tarantino"), // Writers
                        Arrays.asList("Leonardo DiCaprio", "Brad Pitt", "Margot Robbie"), // Main Cast
                        7.7 // Rating
                ),

                new Movie("751f6871-f68b-461c-828d-12b1df47af10", // ID
                        "One Flew Over the Cuckoo\"s Nest", // Title
                        "A criminal pleads insanity after getting into trouble again and once in the mental institution rebels against the oppressive nurse and rallies up the scared patients.", // Description
                        Arrays.asList(Genre.DRAMA), // Genres
                        1975, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BZjA0OWVhOTAtYWQxNi00YzNhLWI4ZjYtNjFjZTEyYjJlNDVlL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_.jpg", // Image URL
                        133, // Length in minutes
                        Arrays.asList("Milos Forman"), // Directors
                        Arrays.asList("Lawrence Hauben", "Bo Goldman"), // Writers
                        Arrays.asList("Jack Nicholson", "Louise Fletcher", "William Redfield"), // Main Cast
                        8.7 // Rating
                ),

                new Movie("7760c868-c4ce-46b9-87ec-8cf2bcf3d0fe", // ID
                        "Pulp Fiction", // Title
                        "The lives of two mob hit men, a boxer, a gangster's wife, and a pair of diner bandits intertwine in four tales of violence and redemption.", // Description
                        Arrays.asList(Genre.CRIME, Genre.DRAMA), // Genres
                        1994, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg", // Image URL
                        154, // Length in minutes
                        Arrays.asList("Quentin Tarantino"), // Directors
                        Arrays.asList("Quentin Tarantino", "Roger Avary"), // Writers
                        Arrays.asList("John Travolta", "Uma Thurman", "Samuel L. Jackson"), // Main Cast
                        8.9 // Rating
                ),

                new Movie("a1857686-0eac-474f-befb-fc7cade26a2f", // ID
                        "Puss in Boots", // Title
                        "An outlaw cat, his childhood egg-friend, and a seductive thief kitty set out in search for the eggs of the fabled Golden Goose to clear his name, restore his lost honor, and regain the trust of his mother and town.", // Description
                        Arrays.asList(Genre.ANIMATION, Genre.ADVENTURE, Genre.COMEDY), // Genres
                        2011, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BNjMyMDBjMGUtNDUzZi00N2MwLTg1MjItZTk2MDE1OTZmNTYxXkEyXkFqcGdeQXVyMTQ5NjA0NDM0._V1_FMjpg_UX1000_.jpg", // Image URL
                        90, // Length in minutes
                        Arrays.asList("Chris Miller"), // Directors
                        Arrays.asList("Tom Wheeler", "Brian Lynch"), // Writers
                        Arrays.asList("Antonio Banderas", "Salma Hayek", "Zach Galifianakis"), // Main Cast
                        6.6 // Rating
                ), new Movie("9996624f-9627-430a-b763-ed0e6c1a8e1b", // ID
                        "Saving Private Ryan", // Title
                        "Following the Normandy Landings, a group of U.S. soldiers go behind enemy lines to retrieve a paratrooper whose brothers have been killed in action.", // Description
                        Arrays.asList(Genre.ACTION, Genre.DRAMA, Genre.WAR), // Genres
                        1998, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BZjhkMDM4MWItZTVjOC00ZDRhLThmYTAtM2I5NzBmNmNlMzI1XkEyXkFqcGdeQXVyNDYyMDk5MTU@._V1_FMjpg_UX1000_.jpg", // Image URL
                        169, // Length in minutes
                        Arrays.asList("Steven Spielberg"), // Directors
                        Arrays.asList("Robert Rodat"), // Writers
                        Arrays.asList("Tom Hanks", "Matt Damon", "Tom Sizemore"), // Main Cast
                        8.6 // Rating
                ), new Movie("521ba69d-f716-4a3d-a048-39cb05a685b1", // ID
                        "Schindler's List", // Title
                        "In German-occupied Poland during World War II, Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazi Germans.", // Description
                        Arrays.asList(Genre.BIOGRAPHY, Genre.DRAMA, Genre.HISTORY), // Genres
                        1993, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_.jpg", // Image URL
                        195, // Length in minutes
                        Arrays.asList("Steven Spielberg"), // Directors
                        Arrays.asList("Steven Zaillian", "Thomas Keneally"), // Writers
                        Arrays.asList("Liam Neeson", "Ralph Fiennes", "Ben Kingsley"), // Main Cast
                        8.9 // Rating
                ), new Movie("8d948831-a076-4ac0-b939-1cf547a6cf58", // ID
                        "Seven", // Title
                        "Two detectives, a rookie and a veteran, hunt a serial killer who uses the seven deadly sins as his modus operandi.", // Description
                        Arrays.asList(Genre.CRIME, Genre.DRAMA, Genre.MYSTERY, Genre.THRILLER), // Genres
                        1995, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BOTUwODM5MTctZjczMi00OTk4LTg3NWUtNmVhMTAzNTNjYjcyXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UX1000_.jpg", // Image URL
                        127, // Length in minutes
                        Arrays.asList("David Fincher"), // Directors
                        Arrays.asList("Andrew Kevin Walker"), // Writers
                        Arrays.asList("Morgan Freeman", "Brad Pitt", "Kevin Spacey"), // Main Cast
                        8.6 // Rating
                ),

                new Movie("3588776d-a182-4de8-9e05-5157b40191df", // ID
                        "Spirited Away", // Title
                        "During her family's move to the suburbs, a sullen 10-year-old girl wanders into a world ruled by gods, witches, and spirits, and where humans are changed into beasts.", // Description
                        Arrays.asList(Genre.ANIMATION, Genre.ADVENTURE, Genre.FAMILY, Genre.FANTASY, Genre.MYSTERY), // Genres
                        2001, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BMjlmZmI5MDctNDE2YS00YWE0LWE5ZWItZDBhYWQ0NTcxNWRhXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_FMjpg_UX1000_.jpg", // Image URL
                        125, // Length in minutes
                        Arrays.asList("Hayao Miyazaki"), // Directors
                        Arrays.asList("Hayao Miyazaki"), // Writers
                        Arrays.asList("Daveigh Chase", "Suzanne Pleshette", "Miyu Irino"), // Main Cast
                        8.6 // Rating
                ), new Movie("a45e4b03-ece7-49e7-8144-4f2a6fe03432", // ID
                        "Star Wars: Episode V - The Empire Strikes Back", // Title
                        "After the rebels are brutally overpowered by the Empire on the ice planet Hoth, Luke Skywalker begins Jedi training with Yoda, while his friends are pursued by Darth Vader and a bounty hunter named Boba Fett all over the galaxy.", // Description
                        Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY, Genre.SCIENCE_FICTION), // Genres
                        1980, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BYmU1NDRjNDgtMzhiMi00NjZmLTg5NGItZDNiZjU5NTU4OTE0XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg", // Image URL
                        124, // Length in minutes
                        Arrays.asList("Irvin Kershner"), // Directors
                        Arrays.asList("Leigh Brackett", "Lawrence Kasdan", "George Lucas"), // Writers
                        Arrays.asList("Mark Hamill", "Harrison Ford", "Carrie Fisher"), // Main Cast
                        8.7 // Rating
                ), new Movie("70638b3c-8a1e-414a-9a53-05ebf64078a2", // ID
                        "The Dark Knight", // Title
                        "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, the caped crusader must come to terms with one of the greatest psychological tests of his ability to fight injustice.", // Description
                        Arrays.asList(Genre.ACTION, Genre.CRIME, Genre.DRAMA), // Genres
                        2008, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BMTk4ODQzNDY3Ml5BMl5BanBnXkFtZTcwODA0NTM4Nw@@._V1_FMjpg_UX1000_.jpg", // Image URL
                        152, // Length in minutes
                        Arrays.asList("Christopher Nolan"), // Directors
                        Arrays.asList("Jonathan Nolan", "Christopher Nolan"), // Writers
                        Arrays.asList("Christian Bale", "Heath Ledger", "Aaron Eckhart"), // Main Cast
                        9.0 // Rating
                ), new Movie("81d317b0-29e5-4846-97a6-43c07f3edf4a", // ID
                        "The Godfather", // Title
                        "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.", // Description
                        Arrays.asList(Genre.DRAMA), // Genres
                        1972, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg", // Image URL
                        175, // Length in minutes
                        Arrays.asList("Francis Ford Coppola"), // Directors
                        Arrays.asList("Mario Puzo", "Francis Ford Coppola"), // Writers
                        Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"), // Main Cast
                        9.2 // Rating
                ), new Movie("8d47a927-7e9c-4b67-ba51-790a55f6985b", // ID
                        "The Good, the Bad and the Ugly", // Title
                        "A bounty hunting scam joins two men in an uneasy alliance against a third in a race to find a fortune in gold buried in a remote cemetery.", // Description
                        Arrays.asList(Genre.WESTERN), // Genres
                        1966, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BNjJlYmNkZGItM2NhYy00MjlmLTk5NmQtNjg1NmM2ODU4OTMwXkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_FMjpg_UX1000_.jpg", // Image URL
                        161, // Length in minutes
                        Arrays.asList("Sergio Leone"), // Directors
                        Arrays.asList("Luciano Vincenzoni", "Agenore Incrocci", "Furio Scarpelli", "Sergio Leone"), // Writers
                        Arrays.asList("Clint Eastwood", "Eli Wallach", "Lee Van Cleef"), // Main Cast
                        8.9 // Rating
                ), new Movie("6d7a6581-665e-4f55-b323-094358849312", // ID
                        "The Lion King", // Title
                        "Lion cub and future king Simba searches for his identity. His eagerness to please others and penchant for testing his boundaries sometimes gets him into trouble.", // Description
                        Arrays.asList(Genre.ANIMATION, Genre.ADVENTURE, Genre.DRAMA, Genre.FAMILY, Genre.MUSICAL), // Genres
                        1994, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BMjIwMjE1Nzc4NV5BMl5BanBnXkFtZTgwNDg4OTA1NzM@._V1_FMjpg_UX1000_.jpg", // Image URL
                        88, // Length in minutes
                        Arrays.asList("Roger Allers", "Rob Minkoff"), // Directors
                        Arrays.asList("Irene Mecchi", "Jonathan Roberts", "Linda Woolverton"), // Writers
                        Arrays.asList("Matthew Broderick", "Jeremy Irons", "James Earl Jones"), // Main Cast
                        8.5 // Rating
                ),

                new Movie("57803b54-5ab7-4c66-a994-0884bcd92b04", // ID
                        "The Lord of the Rings: The Return of the King", // Title
                        "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.", // Description
                        Arrays.asList(Genre.ADVENTURE, Genre.DRAMA, Genre.FANTASY), // Genres
                        2003, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BNzA5ZDNlZWMtM2NhNS00NDJjLTk4NDItYTRmY2EwMWZlMTY3XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UX1000_.jpg", // Image URL
                        201, // Length in minutes
                        Arrays.asList("Peter Jackson"), // Directors
                        Arrays.asList("J.R.R. Tolkien", "Fran Walsh", "Philippa Boyens"), // Writers
                        Arrays.asList("Elijah Wood", "Ian McKellen", "Viggo Mortensen"), // Main Cast
                        8.9 // Rating
                ), new Movie("fff085ba-1b76-4623-9c77-396017ed1e57", // ID
                        "The Lord of the Rings: The Two Towers", // Title
                        "While Frodo and Sam edge closer to Mordor with the help of the shifty Gollum, the divided fellowship makes a stand against Sauron\"s new ally, Saruman, and his hordes of Isengard.", // Description
                        Arrays.asList(Genre.ADVENTURE, Genre.DRAMA, Genre.FANTASY), // Genres
                        2002, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BZTUxNzg3MDUtYjdmZi00ZDY1LTkyYTgtODlmOGY5N2RjYWUyXkEyXkFqcGdeQXVyMTA0MTM5NjI2._V1_FMjpg_UX1000_.jpg", // Image URL
                        179, // Length in minutes
                        Arrays.asList("Peter Jackson"), // Directors
                        Arrays.asList("J.R.R. Tolkien", "Fran Walsh", "Philippa Boyens"), // Writers
                        Arrays.asList("Elijah Wood", "Ian McKellen", "Viggo Mortensen"), // Main Cast
                        8.7 // Rating
                ), new Movie("e2d9913d-3869-454c-9fbf-a63aaf57bedf", // ID
                        "The Matrix", // Title
                        "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.", // Description
                        Arrays.asList(Genre.ACTION, Genre.SCIENCE_FICTION), // Genres
                        1999, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UX1000_.jpg", // Image URL
                        136, // Length in minutes
                        Arrays.asList("Lana Wachowski", "Lilly Wachowski"), // Directors
                        Arrays.asList("Lana Wachowski", "Lilly Wachowski"), // Writers
                        Arrays.asList("Keanu Reeves", "Laurence Fishburne", "Carrie-Anne Moss"), // Main Cast
                        8.7 // Rating
                ),

                new Movie("dc099995-3b61-44ce-b817-b029b33a1ce1", // ID
                        "The Shawshank Redemption", // Title
                        "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.", // Description
                        Arrays.asList(Genre.DRAMA), // Genres
                        1994, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BNDE3ODcxYzMtY2YzZC00NmNlLWJiNDMtZDViZWM2MzIxZDYwXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_.jpg", // Image URL
                        142, // Length in minutes
                        Arrays.asList("Frank Darabont"), // Directors
                        Arrays.asList("Stephen King", "Frank Darabont"), // Writers
                        Arrays.asList("Tim Robbins", "Morgan Freeman", "Bob Gunton"), // Main Cast
                        9.3 // Rating
                ), new Movie("1376dad0-10d4-499c-843a-cb05908b7b35", // ID
                        "The Silence of the Lambs", // Title
                        "A young FBI cadet must receive the help of an incarcerated and manipulative cannibal killer to help catch another serial killer, a madman who skins his victims.", // Description
                        Arrays.asList(Genre.CRIME, Genre.DRAMA, Genre.THRILLER), // Genres
                        1991, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BNjNhZTk0ZmEtNjJhMi00YzFlLWE1MmEtYzM1M2ZmMGMwMTU4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UX1000_.jpg", // Image URL
                        118, // Length in minutes
                        Arrays.asList("Jonathan Demme"), // Directors
                        Arrays.asList("Thomas Harris", "Ted Tally"), // Writers
                        Arrays.asList("Jodie Foster", "Anthony Hopkins", "Scott Glenn"), // Main Cast
                        8.6 // Rating
                ),

                new Movie("4e66285f-5949-416e-afa8-716e0c3ef46c", // ID
                        "The Usual Suspects", // Title
                        "A sole survivor tells of the twisty events leading up to a horrific gun battle on a boat, which begin when five criminals meet at a seemingly random police lineup.", // Description
                        Arrays.asList(Genre.CRIME, Genre.MYSTERY, Genre.THRILLER), // Genres
                        1995, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BYTViNjMyNmUtNDFkNC00ZDRlLThmMDUtZDU2YWE4NGI2ZjVmXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_FMjpg_UX1000_.jpg", // Image URL
                        106, // Length in minutes
                        Arrays.asList("Bryan Singer"), // Directors
                        Arrays.asList("Christopher McQuarrie"), // Writers
                        Arrays.asList("Kevin Spacey", "Gabriel Byrne", "Chazz Palminteri"), // Main Cast
                        8.6 // Rating
                ),

                new Movie("d95d6912-b281-4e08-86b8-f9101f5f2c15", // ID
                        "The Wolf of Wall Street", // Title
                        "Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.", // Description
                        Arrays.asList(Genre.BIOGRAPHY, Genre.COMEDY, Genre.CRIME, Genre.DRAMA), // Genres
                        2013, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BMjIxMjgxNTk0MF5BMl5BanBnXkFtZTgwNjIyOTg2MDE@._V1_FMjpg_UX1000_.jpg", // Image URL
                        180, // Length in minutes
                        Arrays.asList("Martin Scorsese"), // Directors
                        Arrays.asList("Terence Winter"), // Writers
                        Arrays.asList("Leonardo DiCaprio", "Jonah Hill", "Margot Robbie"), // Main Cast
                        8.2),

                new Movie("ccf4989e-e85b-4119-a113-7ca5298a1b17", // ID
                        "Toy Story", // Title
                        "A cowboy doll is profoundly threatened and jealous when a new spaceman action figure supplants him as top toy in a boy's bedroom.", // Description
                        Arrays.asList(Genre.ANIMATION, Genre.ADVENTURE, Genre.COMEDY, Genre.FAMILY, Genre.FANTASY), // Genres
                        1995, // Release Year
                        "https://m.media-amazon.com/images/M/MV5BMDU2ZWJlMjktMTRhMy00ZTA5LWEzNDgtYmNmZTEwZTViZWJkXkEyXkFqcGdeQXVyNDQ2OTk4MzI@._V1_.jpg", // Image URL
                        81, // Length in minutes
                        Arrays.asList("John Lasseter"), // Directors
                        Arrays.asList("John Lasseter", "Pete Docter", "Andrew Stanton"), // Writers
                        Arrays.asList("Tom Hanks", "Tim Allen", "Don Rickles"), // Main Cast
                        8.3 // Rating
                ));

        assertEquals(expected, homeController.observableMovies);

    }

    @Test
    void query_filter_matches_with_lower_and_uppercase_letters(){
        // given
        homeController.initializeState();
        String query = "IfE";

        // when
        List<Movie> actual = homeController.filterByQuery(homeController.observableMovies, query);

        // then
        List<Movie> expected = Arrays.asList(
                new Movie(
                        "Life Is Beautiful",
                        "When an open-minded Jewish librarian and his son become victims of the Holocaust, he uses a perfect mixture of will, humor, and imagination to protect his son from the dangers around their camp." ,
                        Arrays.asList(Genre.DRAMA, Genre.ROMANCE)),
                new Movie(
                        "The Wolf of Wall Street",
                        "Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.",
                        Arrays.asList(Genre.DRAMA, Genre.ROMANCE, Genre.BIOGRAPHY))
        );

        assertEquals(expected, actual);
    }

    @Test
    void query_filter_with_null_movie_list_throws_exception(){
        // given
        homeController.initializeState();
        String query = "IfE";

        // when and then
        assertThrows(IllegalArgumentException.class, () -> homeController.filterByQuery(null, query));
    }

    @Test
    void query_filter_with_null_value_returns_unfiltered_list() {
        // given
        homeController.initializeState();
        String query = null;

        // when
        List<Movie> actual = homeController.filterByQuery(homeController.observableMovies, query);

        // then
        assertEquals(homeController.observableMovies, actual);
    }

    @Test
    void genre_filter_with_null_value_returns_unfiltered_list() {
        // given
        homeController.initializeState();
        Genre genre = null;

        // when
        List<Movie> actual = homeController.filterByGenre(homeController.observableMovies, genre);

        // then
        assertEquals(homeController.observableMovies, actual);
    }

    @Test
    void genre_filter_returns_all_movies_containing_given_genre() {
        // given
        homeController.initializeState();
        Genre genre = Genre.DRAMA;

        // when
        List<Movie> actual = homeController.filterByGenre(homeController.observableMovies, genre);

        // then
        assertEquals(4, actual.size());
    }

    @Test
    void no_filtering_ui_if_empty_query_or_no_genre_is_set() {
        // given
        homeController.initializeState();

        // when
        homeController.applyAllFilters("", null);

        // then
        assertEquals(homeController.allMovies, homeController.observableMovies);
    }


    @Test
    void test_if_Movies_Between_StartYear_And_Endyear() {
        // given
        homeController.initializeState();
        int startYear = 1980;
        int endYear = 2001;

        // when
        List<Movie> actual = homeController.getMoviesBetweenYears(homeController.allMovies, startYear, endYear);

        // then
        for (Movie movie : actual) {
            assertTrue(movie.getReleaseYear() >= startYear && movie.getReleaseYear() <= endYear);
            System.out.println(movie.getTitle());
        }
    }
    @Test
    void test_get_Most_Popular_Actor(){
        //given
        homeController.initializeState();

        // when
        String mostPopularActor = homeController.getMostPopularActor(homeController.allMovies);

        // then
        assertEquals("Leonardo DiCaprio", mostPopularActor);
    }


    @Test
    void test_get_Longest_Movie_Title(){
        //given
        homeController.initializeState();

        //when
        int longestMovieTitle = homeController.getLongestMovieTitle(homeController.allMovies);

        //then
        assertEquals(201,longestMovieTitle);
    }

    @Test
    void test_count_Movies_From(){
        //given
        homeController.initializeState();

        //when
        long countMovies =  homeController.countMoviesFrom(homeController.allMovies,"Robert Zemeckis");

        //then
        assertEquals(1,countMovies);

    }

    @Test
    void test_get_Movies_Between_StartYear_And_Endyear(){
        //given
        homeController.initializeState();


        List<Movie> movies = Arrays.asList(
                new Movie("Movie 1", 1999),
                new Movie("Movie 2", 2005),
                new Movie("Movie 3", 2010),
                new Movie("Movie 4", 2015),
                new Movie("Movie 5", 2020)
        );
        int startYear = 2000;
        int endYear = 2015;

        // when
        List<Movie> result = homeController.getMoviesBetweenYears(movies, startYear, endYear);

        // Then
        assertEquals(3, result.size());
    }

    @Test
    void test_if_initialization_of_initializeMovies_is_correct(){
        List<Movie> movies = Movie.initializeMovies();

        assertFalse(movies.isEmpty(), "The list is not supposed to be empty.");

        for (Movie movie : movies) {
            assertFalse(movie.getTitle().isEmpty(), "Title should not be empty.");

            assertFalse(movie.getDescription().isEmpty(), "Description should not be empty.");

            assertFalse(movie.getGenres().isEmpty(), "Genre List should not be empty.");

            assertNotNull(movie.getReleaseYear(), "Release year should not be null.");

            assertNotNull(movie.getRating(), "Rating should not be null.");
        }
    }

}