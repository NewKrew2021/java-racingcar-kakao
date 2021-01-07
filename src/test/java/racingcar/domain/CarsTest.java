package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarsTest {
    private final Cars cars = new Cars();

    @BeforeEach
    void setupGameManager() {
        cars.add(new Car("jayk", 10));
        cars.add(new Car("jack", 12));
        cars.add(new Car("john", 12));
    }

    @Test
    void getMaxLocation() {
        assertThat(cars.getMaxLocation()).isEqualTo(12);
    }

    @Test
    void getWinner() {
        assertThat(cars.getMaxNames()).isEqualTo(Arrays.asList("jack", "john"));
    }

    @Test
    void negativeGetMaxLocation() {
        assertThat(cars.getMaxLocation()).isNotEqualTo(10);
    }

    @Test
    void negativeGetWinner() {
        assertThat(cars.getMaxLocation()).isNotEqualTo(Arrays.asList("jack"));
    }
}
