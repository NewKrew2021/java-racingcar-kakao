package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    Car car1;
    Car car2;
    Car car3;
    Cars cars;

    @BeforeEach
    void setUp() {
        car1 = new Car("mac", 2);
        car2 = new Car("book", 2);
        car3 = new Car("pro", 2);
        cars = new Cars(Arrays.asList(car1, car2, car3));
    }

    @Test
    public void create() {
        assertThat(cars).isEqualTo(new Cars(Arrays.asList(
                new Car("mac", 2),
                new Car("book", 2),
                new Car("pro", 2)
        )));
    }

    @Test
    public void winnerOne() {
        car2.move(6);
        assertThat(cars.winnerNames()).contains("book");
    }

    @Test
    public void winnerTwo() {
        car1.move(6);
        car3.move(6);
        assertThat(cars.winnerNames()).contains("mac", "pro");
    }
}