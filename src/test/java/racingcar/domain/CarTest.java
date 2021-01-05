package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
