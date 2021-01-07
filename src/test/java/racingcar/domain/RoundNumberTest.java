package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundNumberTest {
    @Test
    public void createTest() {
        RoundNumber roundNumber = new RoundNumber(3);
        assertThat(roundNumber).isEqualTo(new RoundNumber(3));
    }

    @Test
    public void runRoundTest() {
        RoundNumber roundNumber = new RoundNumber(3);
        roundNumber.runRound();
        assertThat(roundNumber).isEqualTo(new RoundNumber(2));
    }

    @Test
    public void roundRemainTest() {
        RoundNumber roundNumberRemain = new RoundNumber(1);
        assertThat(roundNumberRemain.isRoundRemain()).isEqualTo(true);
        RoundNumber roundNumberNotRemain = new RoundNumber(0);
        assertThat(roundNumberNotRemain.isRoundRemain()).isEqualTo(false);
    }

}
