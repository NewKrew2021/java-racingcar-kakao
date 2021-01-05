package util;

import org.junit.jupiter.api.Test;
import util.StringUtil;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilTest {
    @Test
    void parseString() {
        String nameString = "pobi,crong,honux";
        List<String> names = StringUtil.parseString(nameString);
        assertThat(names).isEqualTo(Arrays.asList("pobi", "crong", "honux"));
    }
}