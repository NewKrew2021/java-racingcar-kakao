package com.nextstep.racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    void successfullyCreated() {
        Cars cars = new Cars(
                Arrays.asList(
                        new Car("ian", 0),
                        new Car("good", 0),
                        new Car("valid", 0)
                ));

        assertThat(cars.getNumberOfCars()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    void shouldStop(int value) {
        Cars cars = new Cars();
        assertThat(cars.moveResult(value)).isEqualTo(CarResult.STOP);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    void shouldMove(int value) {
        Cars cars = new Cars();
        assertThat(cars.moveResult(value)).isEqualTo(CarResult.MOVE);
    }
}
