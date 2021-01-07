package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private Car car = new Car("coeat");

    @BeforeEach
    void init(){
    }

    @Test
    void toStringTest(){
        assertThat(car.toString())
                .isEqualTo("coeat : ");
    }

    @Test
    void moveTrueTest(){
        car.move(true);
        assertThat(car.toString())
                .isEqualTo("coeat : -");
    }

    @Test
    void moveFalseTest(){
        car.move(false);
        assertThat(car.toString())
                .isEqualTo("coeat : ");
    }

    @Test
    void goOrStopSuccessTest(){
        int src = 8;
        assertThat(car.goOrStop(src))
                .isTrue();
    }

    @Test
    void goOrStopFailTest(){
        int src = 3;
        assertThat(car.goOrStop(src))
                .isFalse();
    }
}
