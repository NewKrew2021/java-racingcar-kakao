package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.CheckMovableByRandomNumber;

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
    @DisplayName("RacingCars 생성 테스트")
    public void makeRacingCarCheck() {
        assertThat(this.racingCars.getRacingCars())
                .containsExactlyInAnyOrderElementsOf(Arrays.asList(new RacingCar("pobi"), new RacingCar("tars"), new RacingCar("ocean")));
    }

    @Test
    @DisplayName("RacingCars 이름 셋팅 테스트")
    public void setUpRacingCarNameCheck() {
        assertThat(racingCars.getRacingCars()).extracting(RacingCar::getName).containsExactly("pobi", "tars", "ocean");
    }

    @Test
    @DisplayName("우승자 선별 테스트")
    public void winnerCheck() {
        List<RacingCar> cars = racingCars.getRacingCars();
        cars.get(1).move(() -> true);
        cars.get(2).move(() -> true);
        assertThat(racingCars.getWinners()).isEqualTo("tars, ocean");
    }
}
