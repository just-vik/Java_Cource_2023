package homework.movie;

import homework.movie.dao.MoviesCollection;
import homework.movie.dao.MoviesCollectionImpl;
import homework.movie.model.Movie;

import java.time.LocalDate;
import java.util.List;

public class MoviesCollectionAppl {
    public static void main(String[] args) {
        // Создаем коллекцию фильмов
        MoviesCollection moviesCollection = new MoviesCollectionImpl(List.of(
                new Movie(101, "T1", "G1", "D1", LocalDate.now().minusYears(10)),
                new Movie(102, "T2", "G2", "D2", LocalDate.now().minusYears(12)),
                new Movie(103, "T3", "G3", "D1", LocalDate.now().minusYears(2)),
                new Movie(104, "T4", "G4", "D3", LocalDate.now().minusYears(5))
        ));

        // Добавляем новый фильм
        Movie newMovie = new Movie(105, "T5", "G5", "D4", LocalDate.now().minusYears(3));
        moviesCollection.addMovie(newMovie);

        // Удаляем фильм по IMDB
        long imdbToRemove = 102;
        moviesCollection.removeMovie(imdbToRemove);

        // Находим фильм по IMDB
        long imdbToFind = 103;
        Movie foundMovie = moviesCollection.findById(imdbToFind);
        if (foundMovie != null) {
            System.out.println("Найден фильм: " + foundMovie.getTitle());
        } else {
            System.out.println("Фильм не найден.");
        }

        // Находим фильмы по жанру
        String genreToFind = "G3";
        Iterable<Movie> moviesByGenre = moviesCollection.findByGenre(genreToFind);
        System.out.println("Фильмы по жанру " + genreToFind + ":");
        for (Movie m : moviesByGenre) {
            System.out.println(m.getTitle());
        }

        // Находим фильмы, созданные в определенном диапазоне дат
        LocalDate fromDate = LocalDate.now().minusYears(8);
        LocalDate toDate = LocalDate.now().minusYears(2);
        Iterable<Movie> moviesBetweenDates = moviesCollection.findMoviesCreatedBetweenDates(fromDate, toDate);
        System.out.println("Фильмы, созданные между " + fromDate + " и " + toDate + ":");
        for (Movie m : moviesBetweenDates) {
            System.out.println(m.getTitle());
        }

        // Выводим общее количество фильмов в коллекции
        int totalMovies = moviesCollection.totalQuantity();
        System.out.println("Общее количество фильмов: " + totalMovies);
    }
}
