package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingGameTest {
    private Engine alwaysMoveEngine;

    @BeforeEach
    void setUp() {
        alwaysMoveEngine = new AlwaysMoveEngine();
    }

    @Test
    void initialize() {
        RacingGame racingGame = RacingGame.initialize(alwaysMoveEngine, Arrays.asList("pobi", "honux", "crong"), 3);

        assertAll(
                () -> assertThat(racingGame.getCurrentRound()).isEqualTo(1),
                () -> assertThat(racingGame.getTotalRound()).isEqualTo(3)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void initializeWithNegativeTotalRound(int invalidTotalRound) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> RacingGame.initialize(alwaysMoveEngine, Arrays.asList("pobi", "honux", "crong"), invalidTotalRound))
                .withMessage("라운드는 양의 정수여야 합니다.");
    }

    @Test
    void moveCars() {
        RacingGame racingGame = RacingGame.initialize(alwaysMoveEngine, Arrays.asList("pobi", "honux", "crong"), 3);

        racingGame.moveCars();

        assertThat(racingGame.getCurrentRound()).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource({"3,true", "4,false"})
    void isEnd(int totalRound, boolean expected) {
        RacingGame racingGame = RacingGame.initialize(alwaysMoveEngine, Arrays.asList("pobi", "honux", "crong"), totalRound);
        for (int i = 0; i < 3; i++) {
            racingGame.moveCars();
        }

        assertThat(racingGame.isEnd()).isEqualTo(expected);
    }

    @Test
    void cannotMoveCars() {
        RacingGame racingGame = RacingGame.initialize(alwaysMoveEngine, Arrays.asList("pobi", "honux", "crong"), 1);
        racingGame.moveCars();

        assertThatIllegalStateException()
                .isThrownBy(racingGame::moveCars)
                .withMessage("종료된 게임입니다.");
    }
}