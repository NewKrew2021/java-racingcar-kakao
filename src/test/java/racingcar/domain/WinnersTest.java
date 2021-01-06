package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {
    @Test
    public void createTest() {
        Winners winners = new Winners(Arrays.asList(new RacingCar("ocean"), new RacingCar("pobi")));
        assertThat(winners).isEqualTo(new Winners(Arrays.asList(new RacingCar("ocean"), new RacingCar("pobi"))));
    }
}
