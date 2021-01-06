package Car;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarsTest {
    @Test
    void cars() {
        List<String> carNames = Arrays.asList("pobi", "honux", "crong");
        Cars cars = new Cars(carNames);

        assertThat(cars.getCars())
                .extracting(Car::getName)
                .isEqualTo(Arrays.asList("pobi", "honux", "crong"));
    }

    @Test
    void addCar() {
        Cars cars = new Cars();
        Car car1 = new Car("pobi");
        cars.addCar(car1);
        assertTrue(cars.getCars().size() == 1);
        Car car2 = new Car("honux");
        cars.addCar(car2);
        assertTrue(cars.getCars().size() == 2);
        Car car3 = new Car("crong");
        cars.addCar(car3);
        assertTrue(cars.getCars().size() == 3);
    }

    @Test
    void findLeadingCars() {
        Car winner1 = new Car("win1");
        winner1.move(true);
        winner1.move(true);
        winner1.move(true);
        Car winner2 = new Car("win2");
        winner2.move(true);
        winner2.move(true);
        winner2.move(true);
        Car loser1 = new Car("lose1");
        loser1.move(true);
        loser1.move(true);
        Car loser2 = new Car("lose2");
        loser2.move(true);

        Cars cars = new Cars();
        cars.addCar(loser1);
        cars.addCar(winner1);
        cars.addCar(loser2);
        cars.addCar(winner2);

        assertThat(cars.findLeadingCars())
                .extracting(Car::getName)
                .isEqualTo(Arrays.asList("win1", "win2"));
    }
}