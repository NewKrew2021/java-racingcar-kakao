package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp(){
        car = new Car("yell");
    }

    @Test
    void nextStepTest(){
        car.nextStep();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void nameTest(){
        assertThat(car.getName()).isEqualTo("yell");
    }
}
