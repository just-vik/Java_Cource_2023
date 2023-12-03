package homework.movie.dao;

import homework.movie.model.Movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MoviesCollectionImpl implements MoviesCollection {
    private List<Movie> moviesList; //список для хранения объектов

    //конструктор, для пустого moviesList
    public MoviesCollectionImpl() {
        moviesList = new ArrayList<>();
    }

    //конструктор для moviesList заполняемый списком фильмов
    public MoviesCollectionImpl(List<Movie> movies) {
        this(); //вызов пустого конструктора для списка
        for (Movie m : movies) {
            //moviesList.add(m); //это метод от ArrayList, он не отсекает дубликаты на этапе создания.
            addMovie(m); //вызов метода из класса
        }
    }

    @Override
    public boolean addMovie(Movie movie) {
        if (movie == null) {
            return false;
        }
        if (findById(movie.getImdb()) != null) {
            return false;
        }
        if (moviesList.contains(movie)) {
            return false;
        }
        moviesList.add(movie);
        return true;
    }

    @Override
    public Movie removeMovie(long imdb) {
        Movie victim = findById(imdb); //поиск фильма по imdb
        if (victim != null) {
            moviesList.remove(victim); //удаление фильма из списка
            return victim; //возвращает удаленный фильм
        }
        return null; //возвращает null, если фильм не был найден
    }

    @Override
    public Movie findById(long imdb) {
        for (Movie m : moviesList) {
            if (m.getImdb() == imdb) {
                return m; //возвращает фильм, если он найден по imdb
            }
        }
        return null; //возвращает null, если фильм не был найден
    }

    @Override
    public Iterable<Movie> findByGenre(String genre) {
        List<Movie> foundByGenre = new ArrayList<>();
        for (Movie m : moviesList) {
            if (m.getGenre().equals(genre)) {
                moviesList.add(m);
            }
        }
        return foundByGenre; //возвращает пустой список
    }

    // Находит фильмы определенного режиссера
    @Override
    public Iterable<Movie> findByDirector(String director) {
        List<Movie> foundByDirector = new ArrayList<>();
        for (Movie m : moviesList) {
            if (m.getDirector().equals(director)) {
                moviesList.add(m);
            }
        }
        return foundByDirector;
    }


    @Override
    public Iterable<Movie> findMoviesCreatedBetweenDates(LocalDate from, LocalDate to) {
        List<Movie> foundBetweenDates = new ArrayList<>();
        for (Movie m : moviesList) {
            LocalDate movieDate = m.getDate();
            if (movieDate.isAfter(from) && movieDate.isBefore(to) || movieDate.isEqual(from) || movieDate.isEqual(to)) {
                foundBetweenDates.add(m);
            }
        }
        return foundBetweenDates;
    }


    @Override
    public int totalQuantity() {
        return moviesList.size();
    }

    @Override
    public Iterator<Movie> iterator() {
        return moviesList.iterator();
    }
}
