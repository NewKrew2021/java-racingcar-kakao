package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private Cars cars;

    @Test
    void setCarsTest() {
        cars = new Cars("pobi,crong,honux");
        assertThat(cars.getCars()).extracting(Car::getName).isSubsetOf("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("1회 자동차 이동 확인")
    void moveTest() {
        cars = new Cars("pobi,crong,honux");
        cars.move();
        assertThat(cars.getCars()).extracting(Car::getLocation).isSubsetOf(0, 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 7})
    @DisplayName("Round에 따른 자동차 이동 확인")
    void roundMoveTest(int round) {
        cars = new Cars("pobi,crong,honux");
        for (int i = 0; i < round; i++) {
            cars.move();
        }
        assertThat(cars.getCars()).extracting(Car::getLocation).hasSizeBetween(0, round);
    }

}