package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private Cars cars;

    @BeforeEach
    void init() {
        String carNames = "coeat,dodo,dudu";
        this.cars = new Cars(
                Arrays.stream(carNames.split(","))
                        .map(Car::new)
                        .collect(Collectors.toList()));
    }

    @Test
    void constructorTest() {
        assertThat(this.cars.toString())
                .isEqualTo("coeat : \ndodo : \ndudu : \n");
    }
}
