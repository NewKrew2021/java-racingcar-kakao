package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {

    @Test
    @DisplayName("레이싱 라운드 횟수 테스트")
    public void rountCountTest() {
        Racing racing = new Racing("tars,pobi,ocean", 2);
        assertThat(racing.isEnd()).isFalse();
        racing.playRound();
        assertThat(racing.isEnd()).isFalse();
        racing.playRound();
        assertThat(racing.isEnd()).isTrue();
    }

}
