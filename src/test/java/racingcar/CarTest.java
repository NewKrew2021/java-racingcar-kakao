package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CarTest {
    @Test
    void carNameCheckTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Car.validateName("jaasdf")).withMessageMatching("길이 5 초과");
    }
}
