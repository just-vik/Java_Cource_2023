package homework.movie.test;

import homework.movie.dao.MoviesCollection;
import homework.movie.dao.MoviesCollectionImpl;
import homework.movie.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.citizens.model.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MoviesCollectionImplTest {
    MoviesCollection moviesCollection;
    static final LocalDate now = LocalDate.now();


    @BeforeEach
    void setUp() {
        moviesCollection = new MoviesCollectionImpl(List.of(
                new Movie(1, "A", "A", "A", now.minusYears(3)),
                new Movie(2, "B", "B", "B", now.minusYears(4)),
                new Movie(3, "C", "C", "C", now.minusYears(1)),
                new Movie(4, "D", "D", "D", now.minusYears(2)),
                new Movie(5, "E", "E", "E", now.minusYears(7))

        ));
    }

    @Test
    void testConstructor(){
        // вызываем конструктор с двумя одинаковыми объектами
        moviesCollection = new MoviesCollectionImpl(List.of(
                new Movie(1, "T1","G1", "D1", now.minusYears(2)),
                new Movie(1, "T1","G1", "D1", now.minusYears(2))
        ));
        // проверяем, что добавился только один объект
        assertEquals(1,moviesCollection.totalQuantity());
    }

    @Test
    void addMovie() {
        assertFalse(moviesCollection.addMovie(null));
        assertFalse(moviesCollection.addMovie(new Movie(2, "B", "B", "B", now.minusYears(4))));


    }

    @Test
    void removeMovie() {
        assertNotNull(moviesCollection.removeMovie(5));
        assertNull(moviesCollection.removeMovie(5));//удаляем отсутствующего
        assertEquals(4, moviesCollection.totalQuantity()); // убеждаемся в количестве

    }

    @Test
    void findById() {
        assertNotNull(moviesCollection.findById(1));//проверка существующего
        assertNull(moviesCollection.findById(6));//проверка не существующего

    }

    @Test
    void findByGenre() {
        Movie movie = moviesCollection.findById(1);
        assertNotNull(movie);
        assertEquals("A", movie.getGenre());
    }

    @Test
    void findByDirector() {
        Movie movie = moviesCollection.findById(2);
        assertNotNull(movie);
        assertEquals("B", movie.getDirector());
    }

    @Test
    void findMoviesCreatedBetweenDates() {
        LocalDate from=LocalDate.now().minusYears(4);
        LocalDate to=LocalDate.now();

        Iterable<Movie> movies = moviesCollection.findMoviesCreatedBetweenDates(from,to);
        List<Movie> actual = new ArrayList<>();
        for (Movie m : movies) {
            actual.add(m);
        }
        List<Movie> expected = List.of (
                new Movie(1, "A", "A", "A", now.minusYears(3)),
                new Movie(2, "B", "B", "B", now.minusYears(4)),
                new Movie(3, "C", "C", "C", now.minusYears(1)),
                new Movie(4, "D", "D", "D", now.minusYears(2))
        );
        assertIterableEquals(expected, actual);
    }

    @Test
    void totalQuantity() {
        assertEquals(5, moviesCollection.totalQuantity());
    }

}