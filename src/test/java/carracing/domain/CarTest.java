package carracing.domain;

import carracing.domain.Car;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    void generateCar() {
        Car car = new Car("car1");
        assertThat(car.getCarInfoString()).isEqualTo("car1 : ");
    }

    @Test
    void goTest() {
        Car car = new Car("car1", 2);
        assertThat(car.getCarInfoString()).isEqualTo("car1 : --");
    }

    @Test
    void isValidNameFormat() {
        assertThatThrownBy(() -> new Car(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car("length7")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isPositionEqualMaxMoveDistanceTest_equal() {
        int maxMoveDistance = 2;
        Car car = new Car("car1", 2);
        assertThat(car.isPositionEqualMaxMoveDistance(maxMoveDistance)).isTrue();
    }

    @Test
    void isPositionEqualMaxMoveDistanceTest_unequal() {
        int maxMoveDistance = 2;
        Car car = new Car("car1", 1);
        assertThat(car.isPositionEqualMaxMoveDistance(maxMoveDistance)).isFalse();
    }

}
