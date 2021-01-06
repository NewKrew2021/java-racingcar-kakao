package racingcar;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void isMatchedTest() {
        Car car = new Car("brody", 0);
        assertThat(car.isMatched(0)).isTrue();
        assertThat(car.isMatched(1)).isFalse();
    }

}
