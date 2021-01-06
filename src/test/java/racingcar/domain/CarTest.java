package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.CarNameInvalidException;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp(){
        car = new Car("yell");
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8})
    void nextStepTest(int number){
        for (int i = 0; i < number; i++) {
            car.nextStep(number);
        }
        assertThat(car.getCarInfo().getPosition()).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(strings = {"LONGCA", "LONGCAR", "LONGCARNAME", ""})
    void invalidNameTest(String carName) {
        Assertions.assertThatExceptionOfType(CarNameInvalidException.class).
                isThrownBy(() -> { new Car(carName); });
    }

    @Test
    void nameTest(){
        assertThat(car.getCarInfo().getName()).isEqualTo("yell");
    }

    @ParameterizedTest
    @ValueSource(ints = {-2,-1,0,1,2,3})
    void carGoFailTest(int number) {
        org.junit.jupiter.api.Assertions.assertFalse(car.isCarGo(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    void carGoTrueTest(int number) {
        org.junit.jupiter.api.Assertions.assertTrue(car.isCarGo(number));
    }

}
