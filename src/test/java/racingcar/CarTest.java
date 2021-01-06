package racingcar;

import org.junit.jupiter.api.Test;

import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {
    @Test
    public void testMove() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car.getLocation()).isEqualTo(1);
    }

    @Test
    public void tesStop() {
        Car car = new Car("pobi");
        car.move(3);
        assertThat(car.getLocation()).isEqualTo(0);
    }

    @Test
    public void testNameIsNullOrEmpty() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Car(null);
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Car("");
        });
    }

    @Test
    public void testNameLengthIsOver5() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Car("carcar");
        });
    }
}
