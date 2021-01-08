package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class GameTimeTest {

    GameTime gameTime;

    @BeforeEach
    void setUp() {
        gameTime = new GameTime(1);
    }

    @Test
    void 게임_끝_X() {
        assertThat(gameTime.isEnd()).isFalse();
    }

    @Test
    void 게임_끝() {
        gameTime.process();
        assertThat(gameTime.isEnd()).isTrue();
    }

    @Test
    void 음수() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new GameTime(-1))
                .withMessageContaining("음수 값이 될 수 없습니다.");
    }
}

