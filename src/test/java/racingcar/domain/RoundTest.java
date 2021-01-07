package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RoundTest {

    @Test
    public void create() {
        Round round = new Round(5);
        assertThat(round).isEqualTo(new Round(5));
    }

    @Test
    public void validateRound() {
        assertThatThrownBy(() -> {
            new Round(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void spendRound() {
        Round round = new Round(5);
        round.spendOneRound();
        assertThat(round).isEqualTo(new Round(4));
    }

    @Test
    public void roundEnd() {
        Round round = new Round(1);
        round.spendOneRound();
        assertThat(round.isEndRound()).isTrue();
    }
}
