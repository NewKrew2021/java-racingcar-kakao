package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarManagerTest {
    private Engine alwaysMoveEngine;

    @BeforeEach
    void setUp() {
        alwaysMoveEngine = new AlwaysMoveEngine();
    }

    @Test
    void cars() {
        CarManager carManager = new CarManager();
        carManager.pushCar(new Car(alwaysMoveEngine, "pobi"));
        carManager.pushCar(new Car(alwaysMoveEngine, "honux"));
        carManager.pushCar(new Car(alwaysMoveEngine, "crong"));

        assertThat(carManager.getCars())
                .extracting(Car::getName)
                .isEqualTo(Arrays.asList("pobi", "honux", "crong"));
    }

    @Test
    void winners() {
        Car winner1 = new Car(alwaysMoveEngine, "win1");
        winner1.tryMoving();
        winner1.tryMoving();
        winner1.tryMoving();
        Car winner2 = new Car(alwaysMoveEngine, "win2");
        winner2.tryMoving();
        winner2.tryMoving();
        winner2.tryMoving();
        Car loser1 = new Car(alwaysMoveEngine, "lose1");
        loser1.tryMoving();
        loser1.tryMoving();
        Car loser2 = new Car(alwaysMoveEngine, "lose2");
        loser2.tryMoving();

        CarManager carManager = new CarManager();
        carManager.pushCar(loser1);
        carManager.pushCar(winner1);
        carManager.pushCar(loser2);
        carManager.pushCar(winner2);

        assertThat(carManager.findWinnerCars())
                .extracting(Car::getName)
                .isEqualTo(Arrays.asList("win1", "win2"));
    }
}