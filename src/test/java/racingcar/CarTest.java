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

    @Test
    void makeRandomNumberTest(){
        Car car = new Car();
        assertThat(car.makeRandomNumber()).isGreaterThan(-1).isLessThan(10);
    }

    @Test
    void updateCarPositionTest(){
        Car car = new Car();
        int stopDistance = 0;
        int goDistance = 1;
        assertThat(car.updateCarPosition(stopDistance)).isEqualTo(0);
        assertThat(car.updateCarPosition(goDistance)).isEqualTo(1);

    }
}
