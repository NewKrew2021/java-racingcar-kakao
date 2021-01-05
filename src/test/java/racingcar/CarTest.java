package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void getDistanceTest(){
        Car car = new Car();
        int stopRandomNumber = 3;
        int goRandomNumber = 4;
        assertThat(car.getDistance(stopRandomNumber)).isEqualTo(0);
        assertThat(car.getDistance(goRandomNumber)).isEqualTo(1);
    }
}
