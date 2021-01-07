package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.CheckMovable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingCarsTest {
    RacingCars racingCars;

    @BeforeEach
    public void setUp() {
        this.racingCars = RacingCarsFactory.randomNumberCars("pobi,tars,ocean");
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
    @DisplayName("playRound 메소드 테스트")
    public void playRoundTest() {
        RacingCars racingCars =
                new RacingCars(Arrays.asList(new RacingCar("pobi"), new RacingCar("tars"), new RacingCar("ocean")), () -> true);
        RoundResult result = racingCars.playRound();
        assertThat(result.getResult().get("pobi")).isEqualTo(1);
        assertThat(result.getResult().get("tars")).isEqualTo(1);
        assertThat(result.getResult().get("ocean")).isEqualTo(1);
    }

    @Test
    @DisplayName("우승자 선별 테스트")
    public void WinnerCheck() {
        List<RacingCar> cars = racingCars.getRacingCars();
        moveCar(cars.get(0), 9);
        moveCar(cars.get(1), 3);
        moveCar(cars.get(2), 5);
        assertThat(racingCars.getWinners()).containsExactlyInAnyOrderElementsOf(Arrays.asList(new String[] {"pobi"}));
    }

    @Test
    @DisplayName("우승자 여러 명 선별 테스트")
    public void tieWinnerCheck() {
        List<RacingCar> cars = racingCars.getRacingCars();
        moveCar(cars.get(0), 5);
        moveCar(cars.get(1), 9);
        moveCar(cars.get(2), 9);
        assertThat(racingCars.getWinners()).containsExactlyInAnyOrderElementsOf(Arrays.asList(new String[] {"tars", "ocean"}));
    }

    private void moveCar(RacingCar racingCar, int times) {
        for (int i = 0; i < times; i++) {
            racingCar.move(() -> true);
        }
    }
}
