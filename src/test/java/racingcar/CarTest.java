package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {

    @Test
    public void moveTest(){
        Car car = new Car();
        car.move(5);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void validNumberTest() {
        Car car = new Car();
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    car.move(10);
                }).withNoCause();
    }
}
