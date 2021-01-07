package racegame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차의 상태 저장 테스트")
    public void carCreateTest() {
        Car car = new Car("pobi", 3);
        assertThat(car.toString()).isEqualTo("pobi : ---");
    }

    @Test
    @DisplayName("자동차 move 테스트 : 이동이 가능한 경우")
    public void carCanMoveTest() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);

        Car car2 = new Car("pobi");
        car2.move(9);
        assertThat(car2.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 move 테스트 : 이동이 불가능한 경우")
    public void carCannotMoveTest() {
        Car car = new Car("pobi");
        car.move(1);
        assertThat(car.getPosition()).isEqualTo(0);

        Car car2 = new Car("pobi");
        car.move(3);
        assertThat(car2.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 위치가 특정값과 동일할 때 테스트")
    public void carPositionCompareWhenSame() {
        Car car = new Car("pobi", 4);
        assertThat(car.isEqualPosition(4)).isEqualTo(true);
    }

    @Test
    @DisplayName("자동차 위치가 특정값과 동일한지 체크하는 메서드 테스트")
    public void carPositionCompareWhenDifferent() {
        Car car = new Car("hue", 4);
        assertThat(car.isEqualPosition(5)).isEqualTo(false);
    }

}
