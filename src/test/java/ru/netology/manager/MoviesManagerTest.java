package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoviesManagerTest {

    @Test

    public void test() {

        MoviesManager manager = new MoviesManager();

        manager.add("Film I");
        manager.add("Film II");
        manager.add("Film III");

        String[] actual = manager.findAll();
        String[] expected = {"Film I", "Film II", "Film III"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLatestMoviesByLimit() {
        MoviesManager manager = new MoviesManager();
        manager.add("Film I");
        manager.add("Film II");
        manager.add("Film III");
        manager.add("Film IV");
        manager.add("Film V");
        manager.add("Film VI");
        manager.add("Film VII");

        String[] actual = manager.findLast();
        String[] expected = {"Film VII", "Film VI", "Film V", "Film IV", "Film III"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLatestMoviesLimit3() {
        MoviesManager manager = new MoviesManager(3);

        manager.add("Film I");
        manager.add("Film II");
        manager.add("Film III");
        manager.add("Film IV");

        String[] actual = manager.findLast();
        String[] expected = {"Film IV", "Film III", "Film II"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenThereFewerFilmsThanLimit() {
        MoviesManager manager = new MoviesManager();

        manager.add("Film I");
        manager.add("Film II");
        manager.add("Film III");

        String[] actual = manager.findLast();
        String[] expected = {"Film III", "Film II", "Film I"};

        Assertions.assertArrayEquals(expected, actual);
        Assertions.assertEquals(3, actual.length);
    }

    @Test
    public void testWhenFilmsEqualToLimit() {
        MoviesManager manager = new MoviesManager();

        manager.add("Film I");
        manager.add("Film II");
        manager.add("Film III");
        manager.add("Film IV");
        manager.add("Film V");

        String[] actual = manager.findLast();
        String[] expected = {"Film V", "Film IV", "Film III", "Film II", "Film I"};

        Assertions.assertArrayEquals(expected, actual);
        Assertions.assertEquals(5, actual.length);
    }


    @Test
    public void testEmptyMoviesList() {
        MoviesManager manager = new MoviesManager();

        String[] actual = manager.findLast();
        String[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
        Assertions.assertEquals(0, actual.length);
    }

}
