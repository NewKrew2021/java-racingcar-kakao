package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("길이 5초과 테스트")
    void carNameCheckTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car("asdfas")).withMessageMatching("이름의 길이가 5를 초과했습니다.");
    }

    @ParameterizedTest
    @CsvSource({"3,0","4,1"})
    @DisplayName("3이하 정지, 4이상 전진 테스트")
    void tryForwardTest(int randomResult, int nextLocation){
        car.tryForward(randomResult);
        assertThat(car.getLocation()).isEqualTo(nextLocation);
    }
}