package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import racingcar.domain.RacingCar;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCars;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingCarsTest {
    RacingCars racingCars;

    @BeforeEach
    public void setUp() {
        this.racingCars = RacingCarsFactory.from("pobi,tars,ocean", new CheckMovableByRandomNumber());
    }

    @Test
    public void makeRacingCarCheck() {
        assertThat(this.racingCars.getRacingCars())
                .containsExactlyInAnyOrderElementsOf(Arrays.asList(new RacingCar("pobi"), new RacingCar("tars"), new RacingCar("ocean")));
    }

    @Test
    public void setUpRacingCarNameCheck() {
        assertThat(racingCars.getRacingCars()).extracting(RacingCar::getName).containsExactly("pobi", "tars", "ocean");
    }

    @Test
    public void winnerCheck() {
        List<RacingCar> cars = racingCars.getRacingCars();
        cars.get(1).move(() -> true);
        cars.get(2).move(() -> true);
        assertThat(racingCars.getWinners()).isEqualTo("tars, ocean");
    }
}
