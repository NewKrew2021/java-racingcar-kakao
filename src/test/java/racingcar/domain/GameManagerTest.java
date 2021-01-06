package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameManagerTest {
    private GameManager gameManager;
    private List<Car> cars = new ArrayList<>();

    @BeforeEach
    void setupGameManager(){
        gameManager = new GameManager();
        gameManager.createCars(Arrays.asList("jayk", "jack"));
        cars.add(new Car("jayk", 10));
        cars.add(new Car("jack", 12));
        cars.add(new Car("john", 12));
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

    @Test
    void getMaxLocation(){
        assertThat(GameManager.getMaxLocation(cars)).isEqualTo(12);
    }

    @Test
    void getWinner(){
        assertThat(GameManager.getWinners(cars)).isEqualTo(Arrays.asList("jack", "john"));
    }

    @Test
    void negativeGetMaxLocation(){
        assertThat(GameManager.getMaxLocation(cars)).isNotEqualTo(10);
    }

    @Test
    void negativeGetWinner(){
        assertThat(GameManager.getWinners(cars)).isNotEqualTo(Arrays.asList("jack"));
    }
}
