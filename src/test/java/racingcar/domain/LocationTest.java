package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class LocationTest {
    @Test
    void 음수() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Location(-1))
                .withMessageContaining("값이 음수입니다.");
    }

    @Test
    void 최대값() {
        Location location = new Location(0);
        assertThat(location.max(1)).isEqualTo(1);
    }
}
