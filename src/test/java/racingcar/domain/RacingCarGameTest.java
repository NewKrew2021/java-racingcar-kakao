package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCarGame;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingCarGameTest {

    @Test
    void splitName() {
        RacingCarGame game = new RacingCarGame();
        final String text = "pobi,crong,honux";
        final String[] names = game.splitName(text);

        assertThat(names).contains("pobi").contains("crong").contains("honux");
    }

    @Test
    void initGame() {
        final String text = "pobi,crong,honux";
        RacingCarGame game = new RacingCarGame(text, 3);

        assertThat(game.cars).isEqualTo(new Cars(
                Arrays.asList(
                        new Car("pobi"),
                        new Car("crong"),
                        new Car("honux")
                )));
    }
}