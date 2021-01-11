package carRace.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilTest {

    @Test
    public void isAlphabetString_Test_1() {
        String testString = "abcdefg";
        assertThat(StringUtil.isAlphabetString(testString)).isEqualTo(true);
    }

    @Test
    public void isAlphabetString_Test_2() {
        String testString = "abcdefg h";
        assertThat(StringUtil.isAlphabetString(testString)).isEqualTo(false);
    }

    @Test
    public void isAlphabetString_Test_3() {
        String testString = "ab3defg";
        assertThat(StringUtil.isAlphabetString(testString)).isEqualTo(false);
    }

    @Test
    public void isAlphabetString_Test_4() {
        String testString = " !bcdefg";
        assertThat(StringUtil.isAlphabetString(testString)).isEqualTo(false);
    }
}
