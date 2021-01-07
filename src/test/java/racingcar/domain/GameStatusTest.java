package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameStatusTest {

    private GameStatus gameStatus;

    @BeforeEach
    void setUp() {
        gameStatus = new GameStatus();
    }

    @Test
    void create() {
        assertTrue(gameStatus.isGameEnd());
    }

    @Test
    void notGameEndTest() {
        gameStatus = new GameStatus(5);
        assertFalse(gameStatus.isGameEnd());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void playGameTest(int gameCount) {
        gameStatus = new GameStatus(gameCount);
        gameStatus.playGame();
        assertThat(gameStatus.getGameCount()).isEqualTo(0);
    }

    @Test
    void negativeGameCountTest() {
        assertThatThrownBy(() -> {
            new GameStatus(-1);
        }).isInstanceOf(InvalidGameCountException.class);
    }
}
