package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RacingcarTest {
    private Racingcar racingcar;

    @BeforeEach
    void setUp() {
        racingcar = new Racingcar();
    }

    @Test
    void getName() {
        assertThat(racingcar.getName("pobi,crong,honux")).isEqualTo(Arrays.asList("pobi", "crong", "honux"));
    }

}