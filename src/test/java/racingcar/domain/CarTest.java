package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
import racingcar.io.Text;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CarTest {
    private Car car;

    private static final String VALID_NAME = "valid";
    private static final String INVALID_NAME = "invalid";

    @BeforeEach
    void createCar(){
        car = new Car(VALID_NAME);
    }

    @Test
    void carNameCheckTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Car.validateName(INVALID_NAME))
                .withMessageMatching(Text.ILLEGAL_CAR_NAME_LENGTH);
    }

    @ParameterizedTest
    @CsvSource({"3,0","4,1"})
    void tryForwardTest(int randomResult, int nextLocation){
        car.tryForward(randomResult);
        assertThat(car.getLocation()).isEqualTo(nextLocation);
    }

    @ParameterizedTest
    @CsvSource({"5,true","4,true","3,false","2,false"})
    void isForwardTest(int randomNumber, boolean result) {
        assertThat(car.isForward(randomNumber)).isEqualTo(result);
    }
}
