package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("차의 객체 생성 테스트")
    void generateCar() {
        Car car = new Car("car1");
        assertThat(car.getCarInfoString()).isEqualTo("car1 : ");
    }

    @Test
    @DisplayName("차의 위치를 보여주는 문자열 비교 테스트")
    void getCarInfoString() {
        Car car = new Car("car1", 2);
        assertThat(car.getCarInfoString()).isEqualTo("car1 : --");
    }

    @Test
    @DisplayName("차의 이름 설정에 대한 유효성 테스트 (성공) - 길이 1, 길이 5")
    void isValidNameFormat1() {
        assertThat(new Car("a")).isInstanceOf(Car.class);
        assertThat(new Car("abcde")).isInstanceOf(Car.class);
    }

    @Test
    @DisplayName("차의 이름 설정에 대한 유효성 테스트 (exception 발생) - null, 길이 0, 길이 6")
    void isValidNameFormat2() {
        assertThatThrownBy(() -> new Car(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car("length")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("차의 위치와 파라미터값이 같은지 판단하는 기능 테스트 - 위치가 같을 때")
    void isCarPositionEqualToIndex1() {
        int maxMoveDistance = 2;
        Car car = new Car("car1", 2);
        assertThat(car.isCarPositionEqualToIndex(maxMoveDistance)).isTrue();
    }

    @Test
    @DisplayName("차의 위치와 파라미터값이 같은지 판단하는 기능 테스트 - 위치가 다를 때")
    void isCarPositionEqualToIndex2() {
        int maxMoveDistance = 2;
        Car car = new Car("car1", 1);
        assertThat(car.isCarPositionEqualToIndex(maxMoveDistance)).isFalse();
    }

}
