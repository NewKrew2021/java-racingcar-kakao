package carRace.validations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class InputCheckerTest {

    @ParameterizedTest
    @NullAndEmptySource
    void isValidTestForEmptyAndNullStringArrays(String[] strings){
        assertThat(InputChecker.isValid(strings)).isEqualTo(false);
    }

    @Test
    public void isValidTest() {
        String[] testStrings = new String[]{
                "hello", "wolrd", "How", "Are", "you"
        };
        assertThat(InputChecker.isValid(testStrings)).isEqualTo(true);
    }
}
