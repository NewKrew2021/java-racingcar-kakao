package carracing;

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
        Car car = new Car("car1",2);
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

    @Test
    void isPositionEqualMaxMoveDistanceTest_equal(){
        int maxMoveDistance = 2;
        Car car = new Car("car1",2);
        assertThat(car.isPositionEqualMaxMoveDistance(maxMoveDistance)).isTrue();
    }

    @Test
    void isPositionEqualMaxMoveDistanceTest_unequal(){
        int maxMoveDistance = 2;
        Car car = new Car("car1",1);
        assertThat(car.isPositionEqualMaxMoveDistance(maxMoveDistance)).isFalse();
    }
}
