package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    public void testMove(){
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car.location).isEqualTo(1);
    }
}
