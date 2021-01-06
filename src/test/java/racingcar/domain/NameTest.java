package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.exceptions.InvalidCarNameException;

import static org.assertj.core.api.Assertions.*;

public class NameTest {

    @Test
    void createTest() {
        Name name = new Name("yell");
        assertThat(name).isEqualTo(new Name("yell"));

    }

    @Test
    void blankTextTest() {
        assertThatThrownBy(() ->{ new Name(""); }).isInstanceOf(InvalidCarNameException.class);
        assertThatThrownBy(() ->{ new Name(null); }).isInstanceOf(InvalidCarNameException.class);
    }
}
