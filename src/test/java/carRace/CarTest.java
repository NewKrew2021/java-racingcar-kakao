package carRace;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    Car testCar;

    @BeforeEach
    public void setUp() {
        testCar = new Car("test");
        testCar.go(() -> true);
    }

    @Test
    public void goTest() {
        assertThat(testCar.toString()).isEqualTo("test : -");
    }

    @ParameterizedTest
    @MethodSource("provideCar")
    public void compareToTest(Car otherCar, int expected) {
        assertThat(testCar.compareTo(otherCar)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideCar() {
        Car car1 = new Car("test1");
        Car car2 = new Car("test2");
        Car car3 = new Car("test3");
        car1.go(() -> true);
        car1.go(() -> true);
        car3.go(() -> true);
        return Stream.of(
                Arguments.of(car1, -1),
                Arguments.of(car2, 1),
                Arguments.of(car3, 0)
        );
    }
}
