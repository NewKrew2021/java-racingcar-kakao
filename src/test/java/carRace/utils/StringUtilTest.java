package carRace.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("StringUtil 클래스")
public class StringUtilTest {

    @DisplayName("정상적인 알파벳 string에 대한 테스트")
    @Test
    public void isAlphabetString_Test_true() {
        String testString = "abcdefg";
        assertThat(StringUtil.isAlphabetString(testString)).isEqualTo(true);
    }

    @DisplayName("비어있거나, null인 String에 대해 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    void isAlphabetStringTestForEmptyAndNullString(String string) {
        assertThat(StringUtil.isAlphabetString(string)).isEqualTo(false);
    }

    @DisplayName("실패해야하는 입력 string에 대해 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"abcdefg h", "ab3defg", "  ", " !bcdefg"})
    public void isAlphabetString_Test_false(String testString) {
        assertThat(StringUtil.isAlphabetString(testString)).isEqualTo(false);
    }
}
