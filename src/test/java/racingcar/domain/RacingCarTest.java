package racingcar.domain;

import racingcar.domain.RacingCar;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {
    private RacingCar racingCar;

    @Test
    public void moveRacingCarCheck() {
        racingCar = new RacingCar("ocean");
        racingCar.tryMove(() -> true);
        assertThat(racingCar.getDistance()).isEqualTo(new Distance(1));
    }

    @Test
    public void stopRacingCarCheck() {
        racingCar = new RacingCar("ocean");
        racingCar.tryMove(() -> false);
        assertThat(racingCar.getDistance()).isEqualTo(new Distance(0));
    }

}
