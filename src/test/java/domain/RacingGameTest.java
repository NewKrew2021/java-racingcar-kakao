package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameTest {

    @Test
    void isGameEnd() {
        RacingGame game = new RacingGame(3, "pobi,crong,honux");
        game.playRound();
        game.playRound();
        game.playRound();

        assertThat(game.isEnd()).isTrue();
    }
}
