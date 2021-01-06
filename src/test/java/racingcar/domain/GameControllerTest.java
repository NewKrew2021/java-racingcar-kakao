package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameControllerTest {
    private final List<Car> cars = new ArrayList<>();
    private GameController gameController;

    @BeforeEach
    void setupGameManager(){
        gameController = new GameController();
        gameController.createCars(Arrays.asList("jayk", "jack"));
        cars.add(new Car("jayk", 10));
        cars.add(new Car("jack", 12));
        cars.add(new Car("john", 12));
    }

    @Test
    void setCars() {
        List<Car> cars = gameController.getCars();
        assertThat(cars.size()).isEqualTo(2);

        List<Car> trueCars = Arrays.asList(new Car("jayk"), new Car("jack"));
        List<Car> falseCars = Arrays.asList(new Car("not"), new Car("here"));
        assertThat(cars.equals(trueCars)).isTrue();
        assertThat(cars.equals(falseCars)).isFalse();
    }

    @Test
    void getMaxLocation(){
        assertThat(GameController.getMaxLocation(cars)).isEqualTo(12);
    }

    @Test
    void getWinner(){
        assertThat(GameController.getWinners(cars)).isEqualTo(Arrays.asList("jack", "john"));
    }

    @Test
    void negativeGetMaxLocation(){
        assertThat(GameController.getMaxLocation(cars)).isNotEqualTo(10);
    }

    @Test
    void negativeGetWinner(){
        assertThat(GameController.getWinners(cars)).isNotEqualTo(Arrays.asList("jack"));
    }

    @RepeatedTest(10)
    void simulation(){
        gameController.setGameTime(2);
        gameController.simulateGame();
        List<Car> cars = gameController.getCars();
        for(Car car: cars){
            assertThat(car.getLocation()).isBetween(0, 2);
        }
    }

    @Test
    void noGameSimulation(){
        gameController.setGameTime(0);
        gameController.simulateGame();
        List<Car> cars = gameController.getCars();
        for(Car car: cars){
            assertThat(car.getLocation()).isEqualTo(0);
        }
    }
}
