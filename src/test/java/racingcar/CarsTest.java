package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private static Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars("pobi,crong,honux");
    }

    @Test
    @DisplayName("이름 테스트: 자동차의 이름이 올바르게 입력되는지 테스트")
    void names() {
        List<String> names = Arrays.asList("pobi", "crong", "honux");

        for (int i = 0; i < names.size(); i++) {
            assertThat(cars.getCars().get(i).getName()).isEqualTo(names.get(i));
        }
    }

    @Test
    @DisplayName("전체 이동 테스트: moveAll을 실행했을 때 올바른 이동이 수행되는지 테스트")
    void moveAll() {
        cars.moveAll(() -> 4);
        assertThat(cars.getCars()).allMatch(car -> car.getDistance() == 1);
    }

    @Test
    @DisplayName("우승자 테스트: 우승자를 제대로 판별하는지 테스트")
    void winners() {
        cars.getCars().get(0).move(4);
        assertThat(cars.getWinners()).hasSize(1).contains(cars.getCars().get(0));
    }
}
