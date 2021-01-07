package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.*;

public class RoundResultTest {
    private RoundResult roundResult;

    @Test
    @DisplayName("RoundResult 값 변경 테스트")
    public void changeResultCheck() {
        roundResult = new RoundResult(new HashMap<String, Integer>() {{
            put("tars", 1);
            put("ocean", 2);
        }});
        assertThatThrownBy(() -> roundResult.getResult().put("test", 1)).isInstanceOf(UnsupportedOperationException.class);
    }
}
