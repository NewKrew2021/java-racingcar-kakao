package racingcar;

import racingcar.model.RacingCar;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingCarsTest {

    private RacingCars racingCars;

    @Test
    public void setUpRacingCarNameCheck() {
        racingCars = new RacingCars("pobi,tars,ocean");
        assertThat(racingCars.getRacingCars()).extracting(RacingCar::getName).containsExactly("pobi", "tars", "ocean");
    }

    @Test
    public void winnerCheck() {
        racingCars = new RacingCars("win1,win2,lose");
        racingCars.getRacingCars().get(0).tryMove(9);
        racingCars.getRacingCars().get(1).tryMove(9);
        assertThat(racingCars.getWinners()).extracting(RacingCar::getName).containsExactly("win1","win2");
    }
}
