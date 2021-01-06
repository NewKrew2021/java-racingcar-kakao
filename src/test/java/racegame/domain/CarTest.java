package racegame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    public void carCreateTest() {
        Car car = new Car("pobi", 3);
        assertThat(car.toString()).isEqualTo("pobi : ---");
    }

}
