package racingcar.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class LocationTest {
    @Test
    void moveLocationTest(){
        Location location = new Location();
        location.move(2);
        assertThat(location.getLocation()).isEqualTo(new Location(2).getLocation());
    }

    @Test
    void createLocationTest(){
        Location location = new Location(1);
        assertThat(location).isEqualTo(new Location(1));
    }
}
