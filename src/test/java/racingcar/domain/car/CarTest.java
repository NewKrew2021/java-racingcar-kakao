package racingcar.domain.car;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("초기화된 차량에 대해서 움직였을 때 위치가 제대로 갱신되었는가를 확인한다.")
    @Test
    void moveCarPositionTest() {
        Car car = Car.of("hendo", 0);
        car.moveCarPosition(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }


}
