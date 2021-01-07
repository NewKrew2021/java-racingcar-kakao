package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("이동 테스트: move를 실행했을 때 자동차의 거리 값이 올바르게 증가하는지 테스트")
    void move() {
        Car car = new Car("test", 0);
        assertThat(car.getDistance()).isEqualTo(0);

        car.move();
        assertThat(car.getDistance()).isEqualTo(1);
    }
}
