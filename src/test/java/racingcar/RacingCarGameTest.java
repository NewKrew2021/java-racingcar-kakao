package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingCarGameTest {
    RacingCarGame game;

    @BeforeEach
    void setUp() {
        game = new RacingCarGame();
    }

    @Test
    void splitName() {
        final String text = "pobi,crong,honux";
        final String[] names = game.splitName(text);

        assertThat(names).contains("pobi").contains("crong").contains("honux");
    }

    @Test
    void limitString() {
        final String text = "pobipobi,crong,honux";

        assertThrows(RuntimeException.class, () -> game.splitName(text));
    }

    @Test
    void getWinner() {
        final String text = "crong";
        final int racingNum = 4;

        game.start(text, racingNum);
        List<String> winners = game.getWinners();

        assertThat(winners).contains("crong");
    }

    @Test
    void getWinners() {
        final String text = "crong,wkd";
        final int racingNum = 0;

        game.start(text, racingNum);
        List<String> winners = game.getWinners();

        assertThat(winners).contains("crong").contains("wkd");
    }
}