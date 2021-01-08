package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidNameLengthException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NameTest {

    @Test
    public void create() {
        assertThat(new Name("cafe")).isEqualTo(new Name("cafe"));
    }

    @Test
    public void validateName() {
        assertThatThrownBy(() -> {
            new Name("waylon");
        }).isInstanceOf(InvalidNameLengthException.class);
    }
}
