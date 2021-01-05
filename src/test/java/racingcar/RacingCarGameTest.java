package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingCarGameTest {
    @Test
    void splitName() {
        String text = "pobi,crong,honux";
        RacingCarGame game = new RacingCarGame();
        String[] names = game.splitName(text);

        assertThat(names).contains("pobi").contains("crong").contains("honux");
    }

    @Test
    void limitString() {
        String text = "pobipobi,crong,honux";
        RacingCarGame game = new RacingCarGame();
        assertThrows(RuntimeException.class, () -> game.splitName(text));
    }

    @Test
    void getWinner() {
        String text = "crong";
        int racingNum = 4;
        RacingCarGame game = new RacingCarGame();

        game.start(text, racingNum);
        ArrayList<String> winners = game.getWinners();
        assertThat(winners).contains("crong");
    }

    @Test
    void getWinners() {
        String text = "crong,wkd";
        int racingNum = 0;
        RacingCarGame game = new RacingCarGame();

        game.start(text, racingNum);
        ArrayList<String> winners = game.getWinners();
        assertThat(winners).contains("crong").contains("wkd");
    }
}