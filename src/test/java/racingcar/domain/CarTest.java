package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("yell");
    }

    @Test
    void nextStepTest() {
        car.nextStep(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void nameTest() {
        assertThat(car.getName()).isEqualTo("yell");
    }

    @ParameterizedTest
    @CsvSource({"0,false", "3,false", "4,true", "9,true"})
    void carGoTest(int number, boolean result) {
        assertThat(car.isCarGo(number)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({"0,0", "4,1", "5,1", "3,0"})
    @DisplayName("차 전진 테스트")
    void carNextStepTest(int number, int position) {
        car.nextStep(number);
        assertThat(car.getPosition()).isEqualTo(position);
    }
}
