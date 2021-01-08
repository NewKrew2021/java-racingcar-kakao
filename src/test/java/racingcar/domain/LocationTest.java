package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LocationTest {
    @Test
    void moveLocationTest() {
        Location location = new Location(0);
        location.move(() -> true);
        assertThat(location).isEqualTo(new Location(1));
    }

    @Test
    void createLocationTest() {
        Location location = new Location(1);
        assertThat(location).isEqualTo(new Location(1));
    }

}
