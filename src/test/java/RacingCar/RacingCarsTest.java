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
}
