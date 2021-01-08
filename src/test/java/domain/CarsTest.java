package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    void createCars() {
        Cars cars = new Cars("pobi,crong,honux");
        assertThat(cars.getCars())
                .isEqualTo(Arrays.asList(
                        new Car("pobi"),
                        new Car("crong"),
                        new Car("honux")
                ));
    }
}
