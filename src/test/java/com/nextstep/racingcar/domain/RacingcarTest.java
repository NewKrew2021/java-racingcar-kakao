package com.nextstep.racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingcarTest {
    private final int REPEAT_COUNT = 3;

    @Test
    void oneCarWins() {
        Cars cars = new Cars(Arrays.asList(
                new Car("one", 0),
                new Car("two", 0),
                new Car("three", 2)));
        Racingcar racingcar = new Racingcar(cars, REPEAT_COUNT);

        Cars winners = racingcar.getCars()
                .getWinners();

        assertThat(winners.filterOnlyNames()).isEqualTo(Arrays.asList("three"));
    }

    @Test
    void twoCarWins() {
        Cars cars = new Cars(Arrays.asList(
                new Car("one", 0),
                new Car("two", 2),
                new Car("three", 2)));
        Racingcar racingcar = new Racingcar(cars, REPEAT_COUNT);

        Cars winners = racingcar.getCars()
                .getWinners();

        assertThat(winners.filterOnlyNames()).isEqualTo(Arrays.asList("two", "three"));
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
            racingcar.simulate();
        }

        assertThat(racingcar.isInProgress()).isEqualTo(expected);
    }
}
