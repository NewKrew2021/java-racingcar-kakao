package racingcar.controller;

import org.junit.jupiter.api.Test;
import racingcar.controller.GameManager;
import racingcar.domain.Car;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameManagerTest {
    @Test
    void emptyCarTest() {
        GameManager gameManager = new GameManager();

        assertThat(gameManager.getCars().size()).isEqualTo(0);
    }

    @Test
    void setCars() {
        GameManager gameManager = new GameManager(Arrays.asList("jayk","jack"),0);
        List<Car> cars = gameManager.getCars();

        assertThat(cars.size()).isEqualTo(2);

        List<Car> trueCars = Arrays.asList(new Car("jayk"), new Car("jack"));
        List<Car> falseCars = Arrays.asList(new Car("jak"), new Car("jack"));

        assertThat(cars.equals(trueCars)).isTrue();
        assertThat(cars.equals(falseCars)).isFalse();
    }
}
