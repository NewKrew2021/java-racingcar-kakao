package carRace.validations;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class InputCheckerTest {

    @DisplayName("비어있거나, null인 입력에 대해 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    void isValidTestForEmptyAndNullStringArrays(String[] strings){
        assertThat(InputChecker.isValid(strings)).isEqualTo(false);
    }

    @DisplayName("성공인 입력에 대해 테스트")
    @Test
    public void isValidTest_True() {
        String[] testStrings = new String[]{
                "hello", "wolrd", "How", "Are", "you"
        };
        assertThat(InputChecker.isValid(testStrings)).isEqualTo(true);
    }

    @DisplayName("실패인 입력에 대해 테스트")
    @Test
    public void isValidTest_False(){
        String[] testStrings = new String[]{
                "a", " b", "c", "d ", "2f"
        };
    }
}
