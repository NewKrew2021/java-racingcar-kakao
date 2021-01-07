package racingcar.util;

import org.junit.jupiter.api.Test;
import racingcar.util.StringUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilTest {

    @Test
    public void testSplitComma(){
        String input = "pobi,crong,honux";
        String[] names = StringUtil.splitComma(input);
        assertThat(names).contains("pobi", "crong", "honux");
    }
}
