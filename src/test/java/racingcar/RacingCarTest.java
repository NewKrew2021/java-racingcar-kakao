package racingcar;

import racingcar.model.RacingCar;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {
    private RacingCar racingCar;

    @Test
    public void moveRacingCarCheck() {
        racingCar = new RacingCar("ocean");
        racingCar.tryMove(4);
        assertThat(racingCar.getDist()).isEqualTo(1);
    }

    @Test
    public void stopRacingCarCheck() {
        racingCar = new RacingCar("ocean");
        racingCar.tryMove(3);
        assertThat(racingCar.getDist()).isEqualTo(0);
    }

}
