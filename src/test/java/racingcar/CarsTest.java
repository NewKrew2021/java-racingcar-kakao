package racingcar;

import org.junit.jupiter.api.BeforeEach;
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
    void names() {
        List<String> names = Arrays.asList("pobi", "crong", "honux");

        for (int i = 0; i < names.size(); i++) {
            assertThat(cars.getCars().get(i).getName()).isEqualTo(names.get(i));
        }
    }

    @Test
    void moveAll() {
        cars.moveAll(() -> true);
        assertThat(cars.getCars()).allMatch(car -> car.getDistance() == 1);
    }

    @Test
    void winners() {
        cars.getCars().get(0).move(() -> true);
        assertThat(cars.getWinners()).hasSize(1).contains(cars.getCars().get(0));
    }
}
