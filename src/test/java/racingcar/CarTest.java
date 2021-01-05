package racingcar;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @BeforeEach
    void initializeCar() {
        this.car = new Car("", 0);
    }

    @Test
    void getDistanceTest(){
        int stopRandomNumber = 3;
        int goRandomNumber = 4;
        assertThat(car.getDistance(stopRandomNumber)).isEqualTo(0);
        assertThat(car.getDistance(goRandomNumber)).isEqualTo(1);
    }

    @Test
    void makeRandomNumberTest(){
        assertThat(car.makeRandomNumber()).isGreaterThan(-1).isLessThan(10);
    }

    @Test
    void updateCarPositionTest(){
        int stopDistance = 0;
        int goDistance = 1;
        assertThat(car.updateCarPosition(stopDistance)).isEqualTo(0);
        assertThat(car.updateCarPosition(goDistance)).isEqualTo(1);
    }
}
