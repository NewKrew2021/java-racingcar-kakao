package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.StringUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilTest {

    @Test
    @DisplayName("input 스트링을 ','로 쪼개어 스트링 배열로 반환해야한다.")
    public void testSplitComma(){
        String input = "pobi,crong,honux";
        String[] names = StringUtil.splitComma(input);
        assertThat(names).contains("pobi", "crong", "honux");
    }
}
