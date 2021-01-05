package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

    @Test
    void randomNum() {
        final int num = game.randomNum();

        for (int i = 0; i < 10000; i++) {
            assertThat(num).isGreaterThan(-1).isLessThan(10);
        }
    }

    @Test
    void initGame() {
        final String text = "pobi,crong,honux";
        final String[] names = game.splitName(text);

        game.initGame(names);

        assertThat(game.cars.toString()).contains("pobi").contains("crong").contains("honux");
    }
}