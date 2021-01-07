import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    public void samePosition() {
        Car car1 = new Car("jon", 1);
        Car car2 = new Car("snow", 1);
        assertTrue(car1.isEqualPosition(car2));
    }
    @Test
    public void testMove() {
        Car car1 = new Car("jon", 4);
        Car car2 = new Car("snow", 5);
        car1.move(5);
        assertTrue(car1.isEqualPosition(car2));
    }
}
