package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import racingcar.domain.RacingCar;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCars;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingCarsTest {
    RacingCars racingCars;

    @BeforeEach
    public void setUp() {
        racingCars = new RacingCars("pobi,tars,ocean");
    }

    @Test
    public void setUpRacingCarNameCheck() {
        assertThat(racingCars.getRacingCars()).extracting(RacingCar::getName).containsExactly("pobi", "tars", "ocean");
    }

    @Test
    public void winnerCheck() {
        List<RacingCar> cars = racingCars.getRacingCars();
        cars.get(1).move(7);
        cars.get(2).move(9);
        assertThat(racingCars.getWinners()).isEqualTo("tars, ocean");
    }
}
