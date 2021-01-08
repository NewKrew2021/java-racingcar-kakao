package com.nextstep.racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    private final int MOVE = 9;
    private final int STOP = 0;

    @Test
    void successfullyCreated() {
        List<Car> testingCars = Arrays.asList(
                new Car("ian", 0),
                new Car("good", 0),
                new Car("valid", 0));

        Cars cars = new Cars(testingCars);

        assertThat(cars).isEqualTo(new Cars(testingCars));
    }

    @Test
    void carsWithSameNameShouldThrowError() {
        assertThatThrownBy(() -> new Cars(
                Arrays.asList(
                        new Car("dup", 0),
                        new Car("dup", 0))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void areEqualInHashCode() {
        List<Car> car = Collections.singletonList(new Car("hi", 0));
        Cars cars = new Cars(car);

        assertThat(cars.hashCode())
                .isEqualTo(new Cars(car).hashCode());
    }

    @Test
    void allShouldMove() {
        Cars cars = new Cars(
                Arrays.asList(
                        new Car("ian", 0),
                        new Car("good", 0),
                        new Car("valid", 0)));

        cars.move(() -> true);

        assertThat(cars).isEqualTo(
                new Cars(Arrays.asList(
                        new Car("ian", 1),
                        new Car("good", 1),
                        new Car("valid", 1))));
    }

    @Test
    void testDelegation() {
        Cars cars = new Cars(
                Arrays.asList(
                        new Car("ian", 0),
                        new Car("good", 0),
                        new Car("valid", 0)));

        List<String> names = new ArrayList<>();
        cars.delegate(car -> names.add(car.getName()));

        assertThat(names).contains("ian", "good", "valid");
    }

    @Test
    void oneCarIsTheLead() {
        Cars cars = new Cars(
                Arrays.asList(
                        new Car("ian", 0),
                        new Car("good", 3),
                        new Car("valid", 5)));

        assertThat(cars.getLocationOfHighestAdvancedCar()).isEqualTo(5);
    }

    @Test
    void twoCarsAreInLead() {
        Cars cars = new Cars(
                Arrays.asList(
                        new Car("ian", 0),
                        new Car("good", 5),
                        new Car("valid", 5)));

        assertThat(cars.getLocationOfHighestAdvancedCar()).isEqualTo(5);
    }
}
