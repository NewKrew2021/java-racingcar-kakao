package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    Car car;

    @BeforeEach
    void setInit() {
        car = new Car("kuri", 0);
    }

    @Test
    void createCarTest() {
        assertThat(car).isEqualTo(new Car("kuri", 0));
    }

    @Test
    void moveForwardTest() {
        car.move(() -> true);
        assertThat(car.getLocation()).isEqualTo(1);
    }

    @Test
    void moveStopTest() {
        car.move(() -> false);
        assertThat(car.getLocation()).isEqualTo(0);
    }

}
