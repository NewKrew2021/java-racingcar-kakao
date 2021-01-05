package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CarTest {
    private Car car;

    @BeforeEach
    void createCar(){
        car = new Car("dummy");
    }

    @Test
    void carNameCheckTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Car.validateName("jaasdf")).withMessageMatching("길이 5 초과");
    }

    @ParameterizedTest
    @CsvSource({"3,0","4,1"})
    void tryForwardTest(int randomResult, int nextLocation){
        car.tryForward(randomResult);
        assertThat(car.getLocation()).isEqualTo(nextLocation);
    }

    @ParameterizedTest
    @CsvSource({"5,true","4,true","3,false","2,false"})
    void isForwordTest(int randomNumber, boolean result) {
        assertThat(car.isForword(randomNumber)).isEqualTo(result);
    }
}
