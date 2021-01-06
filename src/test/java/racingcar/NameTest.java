package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @Test
    void create() {
        assertThat(new Name("hendo")).isEqualTo(new Name("hendo"));
    }

    @Test
    void valid() {
        assertThatThrownBy(() -> new Name("hendoo"));
    }

}
