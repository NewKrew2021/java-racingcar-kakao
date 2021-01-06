package racingcar.util;

import racingcar.util.InputValidChecker;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputValidCheckerTest {

    @Test
    public void validNameLengthCheck() {
        assertThat(InputValidChecker.isValidNames("aaaa")).isTrue();
    }

    @Test
    public void invalidNameLengthCheck() {
        assertThat(InputValidChecker.isValidNames("aaaaaa")).isFalse();
    }

    @Test
    public void nameDuplicationCheck() {
        assertThat(InputValidChecker.isValidNames("aaa,aaa,bbb")).isFalse();
        assertThat(InputValidChecker.isValidNames("aaa,bbb,aaa")).isFalse();
    }

    @Test
    public void validRoundCheck() {
        assertThat(InputValidChecker.isValidRounds("bb")).isFalse();
        assertThat(InputValidChecker.isValidRounds("-1")).isFalse();
        assertThat(InputValidChecker.isValidRounds("1")).isTrue();
    }
}
