package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.InvalidCarNameLengthException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NameTest {
    @ParameterizedTest
    @ValueSource(strings = {"", "kuriku"})
    void InvalidNameTest(String name) {
        assertThatExceptionOfType(InvalidCarNameLengthException.class).isThrownBy(() -> new Name(name));
    }

    @Test
    void createNameTest() {
        Name name = new Name("kuri");
        assertThat(name).isEqualTo(new Name("kuri"));
    }
    
}
