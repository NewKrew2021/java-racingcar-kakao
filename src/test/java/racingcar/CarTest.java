package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {


    /*
     * 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
     * */
    @Test
    public void testForward() {

        Car car = new Car("Test");
        car.goForward(4);
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
        car.goForward(3);
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
        car.goForward(9);
        Assertions.assertThat(car.getPosition()).isEqualTo(2);
    }


}
