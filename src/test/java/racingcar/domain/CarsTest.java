package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setInit() {
        cars = new Cars("pobi,crong,honux");
    }

    @Test
    void createCarsTest() {
        assertThat(cars).isEqualTo(new Cars("pobi,crong,honux"));
    }

    @Test
    @DisplayName("1회 자동차 이동 확인")
    void moveTest() {
        cars.move(new RandomNumberMoveStrategy());
        assertThat(cars.getCars()).extracting(Car::getLocation).isSubsetOf(0, 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 7})
    @DisplayName("Round에 따른 자동차 이동 확인")
    void roundMoveTest(int round) {
        for (int i = 0; i < round; i++) {
            cars.move(new RandomNumberMoveStrategy());
        }
        assertThat(cars.getCars()).extracting(Car::getLocation).hasSizeBetween(0, round);
    }

}