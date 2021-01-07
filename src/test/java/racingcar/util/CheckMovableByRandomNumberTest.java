package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CheckMovableByRandomNumberTest {

    @Test
    @DisplayName("이동 가능한 최솟값 테스트")
    public void minMovableNumberCheck() {
        CheckMovableByRandomNumberForTest checkMovableByRandomNumber = new CheckMovableByRandomNumberForTest();
        assertThat(checkMovableByRandomNumber.isMovable()).isFalse();
    }
}
