import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarManagerTest {
    @Test
    void cars() {
        CarManager carManager = new CarManager();
        carManager.pushCar(new Car("pobi"));
        carManager.pushCar(new Car("honux"));
        carManager.pushCar(new Car("crong"));

        assertThat(carManager.getCars())
                .extracting(Car::getName)
                .isEqualTo(Arrays.asList("pobi", "honux", "crong"));
    }

    @Test
    void winners() {
        Car winner1 = new Car("win1");
        winner1.moveOrNot(9);
        winner1.moveOrNot(9);
        winner1.moveOrNot(9);
        Car winner2 = new Car("win2");
        winner2.moveOrNot(9);
        winner2.moveOrNot(9);
        winner2.moveOrNot(9);
        Car loser1 = new Car("lose1");
        loser1.moveOrNot(9);
        loser1.moveOrNot(9);
        Car loser2 = new Car("lose2");
        loser2.moveOrNot(9);

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