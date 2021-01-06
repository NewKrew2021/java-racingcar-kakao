package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.CarNameInvalidException;

import static org.assertj.core.api.Assertions.*;

public class NameTest {

    @Test
    void createTest() {
        Name name = new Name("yell");
        assertThat(name).isEqualTo(new Name("yell"));

    }

    @Test
    void blankTextTest() {
        assertThatThrownBy(() ->{ new Name(""); }).isInstanceOf(CarNameInvalidException.class);
        assertThatThrownBy(() ->{ new Name(null); }).isInstanceOf(CarNameInvalidException.class);
    }
}
