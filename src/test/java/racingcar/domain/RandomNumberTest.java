package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RandomNumberTest {
    @Test
    void invalid() {
        assertThatThrownBy(() -> new RandomNumber(10)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void create() {
        assertThat(new RandomNumber(1)).isEqualTo(new RandomNumber(1));
    }
}
