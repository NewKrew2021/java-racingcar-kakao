package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NameTest {
    @Test
    public void createTest() {
        Name name = new Name("ocean");
        assertThat(name).isEqualTo(new Name("ocean"));
    }
}
