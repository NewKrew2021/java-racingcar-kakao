package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TryNoTest {
    @Test
    void tryRacing() {
        TryNo tryNo = new TryNo(4);

        assertThat(tryNo.tryRacing()).isEqualTo(new TryNo(3));
    }

    @Test
    void invalid() {
        assertThatThrownBy(() -> new TryNo(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void create() {
        assertThat(new TryNo(5)).isEqualTo(new TryNo(5));
    }
}
