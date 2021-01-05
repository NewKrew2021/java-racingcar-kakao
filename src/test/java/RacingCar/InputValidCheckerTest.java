package RacingCar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputValidCheckerTest {

    @Test
    public void validNameLengthCheck() {
        assertThat(InputValidChecker.isValidInput("aaaa")).isTrue();
    }

    @Test
    public void invalidNameLengthCheck() {
        assertThat(InputValidChecker.isValidInput("aaaaaa")).isFalse();
    }


    @Test
    public void nameDuplicationCheck() {
        assertThat(InputValidChecker.isValidInput("aaa,aaa,bbb")).isFalse();
    }
}
