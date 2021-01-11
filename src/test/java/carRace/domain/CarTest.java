package carRace.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("차가 한 칸 이동한다.")
    public void goTest() {
        Car testCar = Car.of("test");
        testCar.go(() -> true);
        assertThat(testCar.toString()).isEqualTo("test : -");
    }

    @ParameterizedTest
    @MethodSource("provideCar")
    @DisplayName("차 위치를 기준으로 차를 비교한다.")
    public void compareToTest(Car otherCar, int expected) {
        Car testCar = Car.of("test");
        testCar.go(() -> true);
        assertThat(testCar.compareTo(otherCar)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideCar() {
        Car car1 = Car.of("long");
        Car car2 = Car.of("short");
        Car car3 = Car.of("equal");
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
