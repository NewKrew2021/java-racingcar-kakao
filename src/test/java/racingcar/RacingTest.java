package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {

    @Test
    public void create() {
        assertThat(new Racing("mac,book,pro", 5))
                .isEqualTo(new Racing("mac,book,pro", 5));
    }
}
