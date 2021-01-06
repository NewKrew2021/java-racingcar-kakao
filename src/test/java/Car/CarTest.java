package Car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {

    @Test
    void length0orNull() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(""));
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(null));
    }

    @Test
    void length5이하() {
        Car car = new Car("12345");
        assertThat(car.getPosition()).isEqualTo(0);
        assertThat(car.getName()).isEqualTo("12345");
    }

    @Test
    void length6이상() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car("123456"));
    }

    @Test
    void move() {
        Car car = new Car("12345");
        car.move(false);
        assertThat(car.getPosition()).isEqualTo(0);

        car.move(true);
        assertThat(car.getPosition()).isEqualTo(1);
    }


    @Test
    void isForwardThan() {
        Car car1 = new Car("12345");
        Car car2 = new Car("12345");
        car1.move(true);
        assertThat(car1.isForwardThan(car2)).isTrue();
    }

    @Test
    void isAtSamePositionWith() {
        Car car1 = new Car("12345");
        Car car2 = new Car("12345");
        assertThat(car1.isAtSamePositionWith(car2)).isTrue();
        car1.move(true);
        car2.move(true);
        assertThat(car1.isAtSamePositionWith(car2)).isTrue();
        car2.move(true);
        assertThat(car1.isAtSamePositionWith(car2)).isFalse();
    }
}
