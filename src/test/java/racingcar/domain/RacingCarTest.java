package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import racingcar.domain.RacingCar;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {
    private RacingCar racingCar;

    @Test
    @DisplayName("RacingCar 이동할 때 테스트")
    public void moveRacingCarCheck() {
        racingCar = new RacingCar("aaa");
        assertThat(racingCar.move(() -> true)).isEqualTo(1);
    }

    @Test
    @DisplayName("RacingCar 이동안할 때 테스트")
    public void stopRacingCarCheck() {
        racingCar = new RacingCar("aaa");
        assertThat(racingCar.move(() -> false)).isEqualTo(0);
    }

}
