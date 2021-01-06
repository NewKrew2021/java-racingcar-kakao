package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RandomNumber;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {


    @Test
    public void moveTest(){
        Car car = new Car("name1");
        car.move(new RandomNumber(4));
        assertThat(car.getPosition()).isEqualTo(1);
    }




}
