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
        String[] tmp = manager.findAll();
        String actual = String.join(", ", tmp);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindLast() {
        Manager manager = new Manager();
        manager.addFilm("newFilm 1");
        manager.addFilm("newFilm 2");
        manager.addFilm("newFilm 3");

        String[] expected = {"newFilm 3", "newFilm 2", "newFilm 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @ParameterizedTest
    @CsvSource({
            "-1,10",
            "0,10",
            "1,1",
            "50,50"
    })
    void shouldOutputLimit(int outputLimit, int expected) {
        Manager manager = new Manager(outputLimit);
        int actual = manager.getOutputLimit();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldFindLastUnderLimit() {
        int outputLimit = 11;
        Manager manager = new Manager(outputLimit);

        manager.addFilm("newFilm5");
        manager.addFilm("newFilm2");
        manager.addFilm("newFilm4");
        manager.addFilm("newFilm3");
        manager.addFilm("newFilm6");
        manager.addFilm("newFilm8");
        manager.addFilm("newFilm1");
        manager.addFilm("newFilm7");

        String[] actual = manager.findLast();
        String[] expected = {"newFilm7", "newFilm1", "newFilm8", "newFilm6", "newFilm3", "newFilm4", "newFilm2", "newFilm5"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastAboveLimit() {
        int outputLimit = 5;
        Manager manager = new Manager(outputLimit);

        manager.addFilm("newFilm5");
        manager.addFilm("newFilm2");
        manager.addFilm("newFilm4");
        manager.addFilm("newFilm3");
        manager.addFilm("newFilm6");
        manager.addFilm("newFilm8");
        manager.addFilm("newFilm1");
        manager.addFilm("newFilm7");

        String[] actual = manager.findLast();
        String[] expected = {"newFilm7", "newFilm1", "newFilm8", "newFilm6", "newFilm3"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastEqualsLimit() {
        int outputLimit = 8;
        Manager manager = new Manager(outputLimit);

        manager.addFilm("newFilm5");
        manager.addFilm("newFilm2");
        manager.addFilm("newFilm4");
        manager.addFilm("newFilm3");
        manager.addFilm("newFilm6");
        manager.addFilm("newFilm8");
        manager.addFilm("newFilm1");
        manager.addFilm("newFilm7");

        String[] actual = manager.findLast();
        String[] expected = {"newFilm7", "newFilm1", "newFilm8", "newFilm6", "newFilm3", "newFilm4", "newFilm2", "newFilm5"};

        Assertions.assertArrayEquals(expected, actual);
    }
}
