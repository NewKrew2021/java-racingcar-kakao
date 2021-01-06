package racingcar;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void moveCarPositionTest() {
        Car car = Car.of("hendo", 0);
        car.moveCarPosition(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }


}
