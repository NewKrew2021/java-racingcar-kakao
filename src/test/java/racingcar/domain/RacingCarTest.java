package racingcar.domain;

import racingcar.domain.RacingCar;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {
    private RacingCar racingCar;

    @Test
    public void moveRacingCarCheck() {
        racingCar = new RacingCar("aaa");
        assertThat(racingCar.move(4)).isEqualTo(1);
    }

    @Test
    public void stopRacingCarCheck() {
        racingCar = new RacingCar("aaa");
        assertThat(racingCar.move(3)).isEqualTo(0);
    }

}
