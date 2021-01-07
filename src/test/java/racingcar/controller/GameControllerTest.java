package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameControllerTest {
    private GameController gameController;

    @BeforeEach
    void setupGameManager() {
        gameController = new GameController();
        gameController.setGameCars(Arrays.asList("jayk", "jack"));
    }

    @Test
    void setCars() {
        Cars cars = gameController.getGameCars();
        assertThat(cars.size()).isEqualTo(2);

        Cars trueCars = new Cars(Arrays.asList(new Car("jayk"), new Car("jack")));
        Cars falseCars = new Cars(Arrays.asList(new Car("not"), new Car("equal")));
        assertThat(cars.equals(trueCars)).isTrue();
        assertThat(cars.equals(falseCars)).isFalse();
    }

    @RepeatedTest(10)
    void simulation() {
        gameController.setGameTime(2);
        gameController.simulateGame();
        Cars cars = gameController.getGameCars();
        for (Car car : cars.getCars()) {
            assertThat(car.getLocation()).isBetween(0, 2);
        }
    }

    @Test
    void noGameSimulation() {
        gameController.setGameTime(0);
        gameController.simulateGame();
        Cars cars = gameController.getGameCars();
        for (Car car : cars.getCars()) {
            assertThat(car.getLocation()).isEqualTo(0);
        }
    }
}
