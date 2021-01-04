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
        int prePosition = car.getPosition();
        assertThat(car.racing(4)).isEqualTo(prePosition + Car.STEP);
    }

    @Test
    void stop() {
        int prePosition = car.getPosition();
        assertThat(car.racing(3)).isEqualTo(prePosition);
    }

    @Test
    void createCar() {
        assertThat(car.getName()).isEqualTo("붕붕이");
    }
}