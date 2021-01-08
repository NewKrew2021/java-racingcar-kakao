package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {

    private RacingCars racingCars;

    @Test
    public void setUpRacingCarNameCheck() {
        racingCars = new RacingCars("pobi,tars,ocean");
        assertThat(racingCars.getRacingCars()).extracting(RacingCar::getName).containsExactly(new Name("pobi"), new Name("tars"), new Name("ocean"));
    }

    @Test
    public void setUpRacingCarWithList() {
        racingCars = new RacingCars(Arrays.asList(new RacingCar("ocean"),new RacingCar("pobi")));
        assertThat(racingCars).isEqualTo(new RacingCars(Arrays.asList(new RacingCar("ocean"),new RacingCar("pobi"))));
    }

    @Test
    public void winnerCheck() {
        List<RacingCar> racingCarList = Arrays.asList(new RacingCar("win1", 3), new RacingCar("win2", 3), new RacingCar("lose", 2));
        racingCars = new RacingCars(racingCarList);
        assertThat(racingCars.getWinners()).isEqualTo(new RacingCars(Arrays.asList(new RacingCar("win1", 3), new RacingCar("win2", 3))));
    }
}
