package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @Test
    public void createTest() {
        Name name = new Name("ocean");
        assertThat(name).isEqualTo(new Name("ocean"));
    }

    @Test
    public void invalidNameLength() {
        assertThatThrownBy(()->{
            Name name = new Name("oceano");
        }).isInstanceOf(IllegalStateException.class);
    }


}
