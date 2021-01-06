package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Racing;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {

    @Test
    public void splitNameTest() {
        Racing rc = new Racing("1,2,3", 5);
        assertThat(rc).isEqualTo(new Racing("1,2,3", 5));
    }

    @Test
    public void tryNoTest() {
        Racing rc = new Racing("1,2,3", 1);
        assertThat(rc.canRace()).isTrue();

        rc.oneRoundRacing();
        assertThat(rc.canRace()).isFalse();
    }

    @Test
    public void racingTest() {
        Racing rc1 = new Racing("1,2,3", 5);
        Racing rc2 = new Racing("1,2,3", 5);

        assertThat(rc1).isEqualTo(rc2);

        rc1.oneRoundRacing();
        assertThat(rc1).isNotEqualTo(rc2);
    }
}
