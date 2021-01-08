package racingcar.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void moveTest(){
        Car car = new Car("name1");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
