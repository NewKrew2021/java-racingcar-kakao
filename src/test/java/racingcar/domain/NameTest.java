package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @Test
    void create() {
        Name huey = new Name("huey");

        assertThat(huey).isEqualTo(new Name("huey"));
    }

    @Test
    void invalid() {
        assertThatThrownBy(() -> new Name("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Name(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Name("huey.j")).isInstanceOf(IllegalArgumentException.class);
    }
}
