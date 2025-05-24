import java.util.*;

class Movie {
    String title;
    String director;
    String genre;
    int releaseYear;
    double rating;

    public Movie(String title, String director, String genre, int releaseYear, double rating) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-15s %-10s %-10d %.1f", title, director, genre, releaseYear, rating);
    }
}

public class MovieManager {
    private ArrayList<Movie> movies = new ArrayList<>();

   
    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    
    public void removeMovie(String title) {
        movies.removeIf(m -> m.title.equalsIgnoreCase(title));
    }

    public void filterByGenre(String genre) {
        System.out.println("\nMovies in genre: " + genre);
        printHeader();
        movies.stream()
              .filter(m -> m.genre.equalsIgnoreCase(genre))
              .forEach(System.out::println);
    }

    public void filterByDirector(String director) {
        System.out.println("\nMovies by director: " + director);
        printHeader();
        movies.stream()
              .filter(m -> m.director.equalsIgnoreCase(director))
              .forEach(System.out::println);
    }


    public void filterByYear(int year) {
        System.out.println("\nMovies released in year: " + year);
        printHeader();
        movies.stream()
              .filter(m -> m.releaseYear == year)
              .forEach(System.out::println);
    }

    public void sortByTitle() {
        movies.sort(Comparator.comparing(m -> m.title.toLowerCase()));
    }

    public void sortByYear() {
        movies.sort(Comparator.comparingInt(m -> m.releaseYear));
    }

    public void sortByRating() {
        movies.sort(Comparator.comparingDouble(m -> -m.rating)); 
    }
    public void displayMovies() {
        System.out.println("\nMovie Collection:");
        printHeader();
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    private void printHeader() {
        System.out.printf("%-20s %-15s %-10s %-10s %s\n", "Title", "Director", "Genre", "Year", "Rating");
        System.out.println("------------------------------------------------------------------");
    }
    public static void main(String[] args) {
        MovieManager manager = new MovieManager();

        manager.addMovie(new Movie("Inception", "Christopher Nolan", "Sci-Fi", 2010, 8.8));
        manager.addMovie(new Movie("Interstellar", "Christopher Nolan", "Sci-Fi", 2014, 8.6));
        manager.addMovie(new Movie("Parasite", "Bong Joon-ho", "Thriller", 2019, 8.6));
        manager.addMovie(new Movie("The Godfather", "Francis Ford Coppola", "Crime", 1972, 9.2));
        manager.addMovie(new Movie("The Dark Knight", "Christopher Nolan", "Action", 2008, 9.0));

        manager.displayMovies();

        manager.filterByGenre("Sci-Fi");
        manager.filterByDirector("Christopher Nolan");
        manager.filterByYear(2019);

        manager.sortByTitle();
        System.out.println("\nSorted by Title:");
        manager.displayMovies();

        manager.sortByYear();
        System.out.println("\nSorted by Release Year:");
        manager.displayMovies();

        manager.sortByRating();
        System.out.println("\nSorted by Rating:");
        manager.displayMovies();

        manager.removeMovie("Parasite");
        System.out.println("\nAfter Removing 'Parasite':");
        manager.displayMovies();
    }
}