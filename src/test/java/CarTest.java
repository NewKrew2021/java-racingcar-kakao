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
        car.moveOrNot(3);
        assertThat(car.getPosition()).isEqualTo(0);
        car.moveOrNot(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

}
