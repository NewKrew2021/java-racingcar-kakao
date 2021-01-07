package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("mac", 4);
    }

    @Test
    public void create() {
        assertThat(car).isEqualTo(new Car("mac", 4));
    }

    @Test
    public void name() {
        assertThat(car.getName()).isEqualTo("mac");
    }

    @Test
    public void position() {
        assertThat(car.getPosition()).isEqualTo(4);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5})
    public void moveOnce(int value) {
        car.move(value);
        assertThat(car.getPosition()).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    public void moveNone(int value) {
        car.move(value);
        assertThat(car.getPosition()).isEqualTo(4);
    }
}
