package carRace.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilTest {

    @Test
    public void isAlphabetString_Test_true() {
        String testString = "abcdefg";
        assertThat(StringUtil.isAlphabetString(testString)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdefg h", "ab3defg", "  ", " !bcdefg"})
    public void isAlphabetString_Test_false(String testString) {
        assertThat(StringUtil.isAlphabetString(testString)).isEqualTo(false);
    }
}
