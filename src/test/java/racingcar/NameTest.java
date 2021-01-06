package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NameTest {

    @Test
    public void testNameFormat() {

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Name("abcdedf"));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Name(""));

    }
}
