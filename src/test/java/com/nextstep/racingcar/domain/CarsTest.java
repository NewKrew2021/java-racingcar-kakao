package com.nextstep.racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {
    private final int MOVE = 9;
    private final int STOP = 0;

    @Test
    void successfullyCreated() {
        Cars cars = new Cars(
                Arrays.asList(
                        new Car("ian", 0),
                        new Car("good", 0),
                        new Car("valid", 0)
                )
        );

        assertThat(cars.getNumberOfCars()).isEqualTo(3);
    }

    @Test
    void carsWithSameNameShouldThrowError() {
        assertThatThrownBy(() -> new Cars(
                Arrays.asList(
                        new Car("dup", 0),
                        new Car("dup", 0)
                )
        )).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void ianAndGoodShouldMove() {
        Cars cars = new Cars(
                Arrays.asList(
                        new Car("ian", 0),
                        new Car("good", 0),
                        new Car("valid", 0)
                )
        );

        cars.move(Arrays.asList(MOVE, MOVE, STOP));

        assertThat(cars.getCars()).isEqualTo(
                Arrays.asList(
                        new Car("ian", 1),
                        new Car("good", 1),
                        new Car("valid", 0)
                )
        );
    }

    @Test
    void oneWinner() {
        Cars cars = new Cars(
                Arrays.asList(
                        new Car("losea", 0),
                        new Car("loseb", 0),
                        new Car("win", 5)
                )
        );

        assertThat(cars.getWinners())
                .isEqualTo(Collections.singletonList(new Car("win", 5)));
    }

    @Test
    void twoWinners() {
        Cars cars = new Cars(
                Arrays.asList(
                        new Car("losea", 0),
                        new Car("wina", 5),
                        new Car("winb", 5)
                )
        );

        assertThat(cars.getWinners())
                .isEqualTo(Arrays.asList(new Car("wina", 5), new Car("winb", 5)));
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

    @Test
    void oneCarIsTheLead() {
        Cars cars = new Cars(
                Arrays.asList(
                        new Car("ian", 0),
                        new Car("good", 3),
                        new Car("valid", 5)
                )
        );

        assertThat(cars.getLocationOfHighestAdvancedCar()).isEqualTo(5);
    }

    @Test
    void twoCarsAreInLead() {
        Cars cars = new Cars(
                Arrays.asList(
                        new Car("ian", 0),
                        new Car("good", 5),
                        new Car("valid", 5)
                )
        );

        assertThat(cars.getLocationOfHighestAdvancedCar()).isEqualTo(5);
    }
}
