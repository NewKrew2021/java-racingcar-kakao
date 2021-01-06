package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputValidCheckerTest {

    @Test
    @DisplayName("유효한 이름 글자수 테스트")
    public void validNameLengthCheck() {
        assertThat(InputValidChecker.validNames("aaaa")).isTrue();
    }

    @Test
    @DisplayName("유효하지 않은 이름 글자수 테스트")
    public void invalidNameLengthCheck() {
        assertThat(InputValidChecker.validNames("aaaaaa")).isFalse();
    }

    @Test
    @DisplayName("중복된 이름 테스트")
    public void nameDuplicationCheck() {
        assertThat(InputValidChecker.validNames("aaa,aaa,bbb")).isFalse();
        assertThat(InputValidChecker.validNames("aaa,bbb,aaa")).isFalse();
    }

    @Test
    @DisplayName("라운드 유효값 테스트")
    public void validRoundCheck() {
        assertThat(InputValidChecker.validRound("bb")).isFalse();
        assertThat(InputValidChecker.validRound("-1")).isFalse();
        assertThat(InputValidChecker.validRound("1")).isTrue();
    }
}
