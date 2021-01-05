package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class RacingcarTest {
    private Racingcar racingcar;
    private RandomNumber randomNumber;

    @BeforeEach
    void set() {
        racingcar = new Racingcar();
        randomNumber = new RandomNumber();
    }

    @Test
    void splitNameCheck() {
        assertThat(racingcar.getCarNames("pobi,crong,honux")).isEqualTo(new String[]{"pobi","crong","honux"});
    }

    @Test
    void carNameCheck() {
        Race.carNames = "pobi,crong,honux";
        assertThat(racingcar.setCarList()).isEqualTo(true);
    }

    @Test
    @DisplayName("1대의 자동차 방향 확인")
    void carDirection() {
        CarStatus dir = randomNumber.setDirection();
        assertThat(dir).isInstanceOfAny(CarStatus.class);
    }

    @Test
    @DisplayName("N대의 자동차 전진/멈춤")
    void carMoveCheck() {
        Race.carNames = "pobi,crong,honux";
        racingcar.setCarList();
        List<Car> car = racingcar.setCalLocTest(randomNumber);
        for (int i = 0; i <car.size() ; i++) {
            assertThat(car.get(i).getLoc()).isNotNegative();
        }
    }




}