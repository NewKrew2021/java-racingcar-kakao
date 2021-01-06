package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;


public class CarsTest {
    @Test
    void maxPosition() {
        Cars cars = new Cars(
            Arrays.asList(
                    new Car("huey", 1),
                    new Car("pavlo", 2),
                    new Car("pobi", 5)
            ));

        assertThat(cars.maxPosition()).isEqualTo(5);
    }

    @Test
    void create() {
        Cars cars = new Cars(
                Arrays.asList(
                        new Car("huey"),
                        new Car("pavlo")
                ));

        assertThat(cars).isEqualTo(new Cars(
                Arrays.asList(
                        new Car("huey"),
                        new Car("pavlo")
                )));
    }
}
