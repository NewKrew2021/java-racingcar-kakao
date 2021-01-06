package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp(){
        car = new Car("yell");
    }

    @ParameterizedTest
    @DisplayName("4칸 이상 시 전진 확인")
    @ValueSource(ints = {4,5,6,7,8})
    void nextStepTest(int number){
        for (int i = 0; i < number; i++) {
            car.move(number);
        }
        assertThat(car.getCarInfo().getPosition()).isEqualTo(number);
    }

    @ParameterizedTest
    @DisplayName("5글자 이상 혹은 공백 문자에 대해 에러 처리 확인")
    @ValueSource(strings = {"LONGCA", "LONGCAR", "LONGCARNAME", ""})
    void invalidNameTest(String carName) {
        Assertions.assertThatExceptionOfType(InvalidCarNameException.class).
                isThrownBy(() -> { new Car(carName); });
    }

    @Test
    void nameTest(){
        assertThat(car.getCarInfo().getName()).isEqualTo("yell");
    }

}
