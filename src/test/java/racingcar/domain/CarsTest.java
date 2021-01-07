package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    public void create() {
        Cars carsNamed = new Cars(Arrays.asList("mac", "book", "pro"));
        assertThat(carsNamed).isEqualTo(Arrays.asList("mac", "book", "pro"));
    }
}