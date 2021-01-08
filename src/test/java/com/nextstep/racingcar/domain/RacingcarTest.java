package com.nextstep.racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingcarTest {
    private final int REPEAT_COUNT = 3;

    @Test
    void carsSuccessfullyCreated() {
        List<Car> cars = Arrays.asList(
                new Car("one", 0),
                new Car("two", 0),
                new Car("three", 0));
        Racingcar racingcar = new Racingcar(new Cars(cars), REPEAT_COUNT);

        assertThat(racingcar.getCars()).isEqualTo(new Cars(cars));
    }

    @Test
    void oneCarWins() {
        Cars cars = new Cars(Arrays.asList(
                new Car("one", 0),
                new Car("two", 0),
                new Car("three", 2)));
        Racingcar racingcar = new Racingcar(cars, REPEAT_COUNT);

        assertThat(racingcar.getWinners()).isEqualTo(new Cars(
                Collections.singletonList(
                        new Car("three", 2))));
    }

    @Test
    void twoCarWins() {
        Cars cars = new Cars(Arrays.asList(
                new Car("one", 0),
                new Car("two", 2),
                new Car("three", 2)));
        Racingcar racingcar = new Racingcar(cars, REPEAT_COUNT);

        assertThat(racingcar.getWinners()).isEqualTo(new Cars(
                Arrays.asList(
                        new Car("two", 2),
                        new Car("three", 2))));
    }

    @Test
    void isCorrectSimulation() {
        Cars cars = new Cars(Arrays.asList(
                new Car("one", 0),
                new Car("two", 0),
                new Car("three", 0)));
        Racingcar racingcar = new Racingcar(cars, REPEAT_COUNT);

        racingcar.simulate(() -> true);

        assertThat(racingcar.getWinners()).isEqualTo(new Cars(
                Arrays.asList(
                        new Car("one", 1),
                        new Car("two", 1),
                        new Car("three", 1))));
    }

    @ParameterizedTest
    @CsvSource({"2,true", "3,false"})
    void checkFinished(int simulateCount, boolean expected) {
        Cars cars = new Cars(Arrays.asList(
                new Car("one", 0),
                new Car("two", 0),
                new Car("three", 0)));
        Racingcar racingcar = new Racingcar(cars, REPEAT_COUNT);

        for (int i = 0; i < simulateCount; i++) {
            racingcar.simulate(() -> true);
        }

        assertThat(racingcar.isInProgress()).isEqualTo(expected);
    }
}
