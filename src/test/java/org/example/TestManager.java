package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestManager {
    @ParameterizedTest
    @CsvSource({
                "newFilm1, newFilm2, newFilm3"
    })
    public void shouldAddFilm(String newFilm1, String newFilm2, String newFilm3) {
        Manager manager = new Manager();
        manager.addFilm(newFilm1);
        manager.addFilm(newFilm2);
        manager.addFilm(newFilm3);

        String expected = "newFilm1, newFilm2, newFilm3";
        String [] tmp = manager.findAll();
        String actual = String.join (", ", tmp);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindLast() {
        Manager manager = new Manager();
        manager.addFilm("newFilm 1");
        manager.addFilm("newFilm 2");
        manager.addFilm("newFilm 3");

        String [] expected = {"newFilm 3","newFilm 2","newFilm 1"};
        String [] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @ParameterizedTest
    @CsvSource({
            "-1,10",
            "0,10",
            "1,1",
            "50,50"
    })
    void shouldOutputLimit (int outputLimit, int expected) {
        Manager manager = new Manager(outputLimit);
        int actual = manager.getOutputLimit();
        Assertions.assertEquals(expected, actual);
    }
    @ParameterizedTest
    @CsvSource({
            "1,1",
            "5,5",
            "6,5",
            "40,5"
    })
    void shouldFindLastLimit(int outputLimit, int expected) {
        Manager manager = new Manager(outputLimit);

        manager.addFilm("newFilm 1");
        manager.addFilm("newFilm 2");
        manager.addFilm("newFilm 3");
        manager.addFilm("newFilm 4");
        manager.addFilm("newFilm 5");

        String [] arr = manager.findLast();

        int actual = arr.length;

        Assertions.assertEquals(expected, actual);

    }

}
