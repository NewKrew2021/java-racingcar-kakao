package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {
    @Test
    @DisplayName("move 메소드의 전달값이 4이상이면 앞으로 움직인다.")
    public void testMove() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car.getLocation()).isEqualTo(1);
    }

    @Test
    @DisplayName("move 메소드의 전달값이 4보다 작으면 움직이지 않는다.")
    public void tesStop() {
        Car car = new Car("pobi");
        car.move(3);
        assertThat(car.getLocation()).isEqualTo(0);
    }

    @Test
    @DisplayName("Car의 이름이 null이거나 비어있다면 IllegalArgumentException을 던진다.")
    public void testNameIsNullOrEmpty() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Car(null);
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Car("");
        });
    }

    @Test
    @DisplayName("Car의 이름이 5자 이상이면 IllegalArgumentException을 던진다.")
    public void testNameLengthIsOver5() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Car("carcar");
        });
    }
}
