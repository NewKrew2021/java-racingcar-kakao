package racingcar;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameManagerTest {
    @Test
    void setCars() {
        GameManager gameManager = new GameManager();
        gameManager.createCars(Arrays.asList("jayk", "jack"));
        List<Car> cars = gameManager.getCars();
        assertThat(cars.size()).isEqualTo(2);

        List<Car> trueCars = Arrays.asList(new Car("jayk"), new Car("jack"));
        List<Car> falseCars = Arrays.asList(new Car("jak"), new Car("jack"));
        assertThat(cars.equals(trueCars)).isTrue();
        assertThat(cars.equals(falseCars)).isFalse();
    }
}
