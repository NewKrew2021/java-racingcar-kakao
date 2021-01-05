package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameManagerTest {
    private GameManager gameManager;

    @BeforeEach
    void setupGameManager(){
        gameManager = new GameManager();
        gameManager.createCars(Arrays.asList("jayk", "jack"));
    }

    @Test
    void setCars() {
        List<Car> cars = gameManager.getCars();
        assertThat(cars.size()).isEqualTo(2);

        List<Car> trueCars = Arrays.asList(new Car("jayk"), new Car("jack"));
        List<Car> falseCars = Arrays.asList(new Car("not"), new Car("here"));
        assertThat(cars.equals(trueCars)).isTrue();
        assertThat(cars.equals(falseCars)).isFalse();
    }
}
