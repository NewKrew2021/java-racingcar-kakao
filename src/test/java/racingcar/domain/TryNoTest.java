package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TryNoTest {
    @Test
    @DisplayName("시도 횟수 객체 생성 테스트")
    public void testCreate() {
        assertNotNull(new TryNo(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("시도 횟수가 0이하이면 IllegalArgumentException을 던진다.")
    public void testInvalidNumber(int number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new TryNo(number));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new TryNo(number));
    }
}
