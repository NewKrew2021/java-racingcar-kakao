package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {

    Car car;


    @BeforeAll
    public void setup(){
        car = new Car("testCar");
    }

    @Test
    public void moveTest(){
        car.move(5);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void validNumberTest() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    car.move(10);
                }).withNoCause();
    }

    @Test
    public void carNameTest(){

    }
}
