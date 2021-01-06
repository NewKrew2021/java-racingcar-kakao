package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void move() {
        Car car = new Car("test", 0);
        car.move(() -> false);
        assertThat(car.getDistance()).isEqualTo(0);

        car.move(() -> true);
        assertThat(car.getDistance()).isEqualTo(1);
    }
}
