package racingcar;

import racingcar.util.InputValidChecker;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputValidCheckerTest {

    @Test
    public void validNameLengthCheck() {
        assertThat(InputValidChecker.isValidNames("ocean")).isTrue();
    }

    @Test
    public void invalidNameLengthCheck() {
        assertThat(InputValidChecker.isValidNames("oocean")).isFalse();
    }

    @Test
    public void nameDuplicationCheck() {
        assertThat(InputValidChecker.isValidNames("ocean,ocean,tars")).isFalse();
    }

    @Test
    public void nameConsecutiveCommaCheck() { assertThat(InputValidChecker.isValidNames("ocean,,tars,pobi")).isFalse(); }

    @Test
    public void nameStartWithCommaCheck() { assertThat(InputValidChecker.isValidNames(",ocean,tars")).isFalse(); }

    @Test
    public void validRoundCheck() { assertThat(InputValidChecker.isValidRounds("55")).isTrue(); }

    @Test
    public void invalidRoundCheck() { assertThat(InputValidChecker.isValidRounds("55a")).isFalse(); }
}
