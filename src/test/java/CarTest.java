import domain.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;

class CarTest {
    @Test
    public void nameTest() {
        assertThatThrownBy(() -> {
            new Car("123456");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new Car(null);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new Car("");
        }).isInstanceOf(IllegalArgumentException.class);

        assertDoesNotThrow(() -> {
            new Car("norma");
        });
    }

    @Test
    public void moveTest() {
        Car car = new Car("norma");
        assertThat(car.move(() -> true))
                .isEqualTo(1);
    }
}