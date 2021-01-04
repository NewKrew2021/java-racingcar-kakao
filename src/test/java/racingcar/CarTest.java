package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    Car car;
    @BeforeEach
    void setUp() {
        car = new Car();
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

}