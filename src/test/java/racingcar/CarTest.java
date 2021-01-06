package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {


    @Test
    public void moveTest(){
        Car car = new Car("name1");
        car.move(new RandomNumber(4));
        assertThat(car.getPosition()).isEqualTo(1);
    }




}
