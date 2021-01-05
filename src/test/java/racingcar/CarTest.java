package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    Car car;
    @BeforeEach
    void setUp() {
        car = new Car("붕붕이");
    }

    @Test
    void goFront() {
        final int prePosition = car.getPosition();
        final int step = 1;

        car.racing(4);

        assertThat(car.getPosition()).isEqualTo(prePosition + step);
    }

    @Test
    void stop() {
        final int prePosition = car.getPosition();

        car.racing(3);
        assertThat(car.getPosition()).isEqualTo(prePosition);
    }

    @Test
    void createCar() {
        assertThat(car.getName()).isEqualTo("붕붕이");
    }
}