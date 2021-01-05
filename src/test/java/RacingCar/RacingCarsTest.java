package RacingCar;

import RacingCar.Model.RacingCar;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingCarsTest {
    @Test
    public void setUpRacingCarNameCheck() {
        RacingCars racingCars = new RacingCars("pobi,tars,ocean");
        assertThat(racingCars.getRacingCars()).extracting(RacingCar::getName).containsExactly("pobi", "tars", "ocean");
    }

    @Test
    public void winnerCheck() {
        RacingCars racingCars = new RacingCars("win1,win2,lose");
        racingCars.getRacingCars().get(0).move(9);
        racingCars.getRacingCars().get(1).move(9);
        assertThat(racingCars.getWinners()).extracting(RacingCar::getName).containsExactly("win1","win2");
    }
}
