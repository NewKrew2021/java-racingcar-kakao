package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

public class NameTest {

    @Test
    void createTest() {
        Name name = new Name("yell");
        assertThat(name).isEqualTo(new Name("yell"));

    }

    @ParameterizedTest
    @NullAndEmptySource
    void blankTextTest(String input) {
        assertThatThrownBy(() ->{ new Name(input); }).isInstanceOf(InvalidCarNameException.class);
    }
}
