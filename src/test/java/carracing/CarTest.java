package carracing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("car1");
    }

    @Test
    void generateCar() {
        assertThat(car.getCarInfoString()).isEqualTo("car1 : ");
    }

    @Test
    void goTest() {
        car.go();
        car.go();
        assertThat(car.getCarInfoString()).isEqualTo("car1 : --");
    }

    @Test
    void makeNameTest_fail_length0() {
        assertThatThrownBy(() -> new Car("")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void makeNameTest_fail_length7() {
        assertThatThrownBy(() -> new Car("invalid")).isInstanceOf(IllegalArgumentException.class);
    }

}
