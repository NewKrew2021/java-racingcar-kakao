package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.Racing;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {

    @Test
    public void create() {
        assertThat(new Racing("mac,book,pro", 5))
                .isEqualTo(new Racing("mac,book,pro", 5));
    }
}
