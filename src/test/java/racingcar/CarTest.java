package racingcar;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("차의 위치값이 맞는지 확인하는 기능을 테스트한다.")
    void isMatchedTest() {
        Car car = new Car("brody", 0);
        assertThat(car.isMatched(0)).isTrue();
        assertThat(car.isMatched(1)).isFalse();
    }

}
