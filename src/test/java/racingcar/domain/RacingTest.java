package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {

    @Test
    public void create() {
        assertThat(new Racing("mac,book,pro", 5))
                .isEqualTo(new Racing("mac,book,pro", 5));
    }

    @Test
    public void endRacing() {
        Racing racing = new Racing("mac,book,pro", 1);
        racing.race();
        assertThat(racing.isFinish()).isTrue();
    }
}
