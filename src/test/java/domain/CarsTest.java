package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private Engine alwaysMoveEngine;

    @BeforeEach
    void setUp() {
        alwaysMoveEngine = new AlwaysMoveEngine();
    }

    @Test
    void create() {
        List<String> carNames = Arrays.asList("pobi", "honux", "crong");
        Cars cars = Cars.create(alwaysMoveEngine, carNames);

        assertThat(cars.getCars())
                .extracting(Car::getName)
                .isEqualTo(carNames);
    }

    @Test
    void moveAllCars() {
        List<String> carNames = Arrays.asList("pobi", "honux", "crong");
        Cars cars = Cars.create(alwaysMoveEngine, carNames);
        cars.moveCars();

        assertThat(cars.getCars())
                .extracting(Car::getPosition)
                .containsOnly(1);
    }

    @Test
    void winners() {
        Car winner1 = CarFixture.createCar("win1", 3);
        Car winner2 = CarFixture.createCar("win2", 3);
        Car loser1 = CarFixture.createCar("lose1", 2);
        Car loser2 = CarFixture.createCar("lose2", 1);

        Cars cars = new Cars(Arrays.asList(loser1, winner1, loser2, winner2));

        assertThat(cars.findWinnerCars())
                .extracting(Car::getName)
                .isEqualTo(Arrays.asList("win1", "win2"));
    }
}
