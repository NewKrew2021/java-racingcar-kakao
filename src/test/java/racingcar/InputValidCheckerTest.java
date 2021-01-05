package racingcar;

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
    }
}
