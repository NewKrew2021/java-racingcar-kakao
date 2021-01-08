package racingcar.controller;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {

    @Test
    public void tryNoTest() {
        Racing rc = new Racing("1,2,3", 1);
        assertThat(rc.canRace()).isTrue();

        rc.oneRoundRacing();
        assertThat(rc.canRace()).isFalse();
    }
}
