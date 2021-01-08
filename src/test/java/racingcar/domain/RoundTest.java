package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundTest {
    @Test
    void createRoundTest() {
        Round round = new Round(2);
        assertThat(round).isEqualTo(new Round(2));
    }
}
