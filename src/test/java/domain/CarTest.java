package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {
    private static final int NEVER_MOVE_CONDITION = 3;
    private static final int ALWAYS_MOVE_CONDITION = 4;

    @Test
    void length0orNull() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(""));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(null));
    }

    @Test
    void length5이하() {
        Car car = new Car("12345");
        assertThat(car.getPosition()).isEqualTo(0);
        assertThat(car.getName()).isEqualTo("12345");
    }

    @Test
    void length6이상() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car("123456"));
    }

    @Test
    void move() {
        Car car = new Car("12345");
        car.moveOrNot(NEVER_MOVE_CONDITION);
        assertThat(car.getPosition()).isEqualTo(0);
        car.moveOrNot(ALWAYS_MOVE_CONDITION);
        assertThat(car.getPosition()).isEqualTo(1);
    }


    @Test
    void isForwardThan() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        car1.moveOrNot(ALWAYS_MOVE_CONDITION);
        assertThat(car1.isForwardThan(car2)).isTrue();
    }

    @Test
    void isSamePositionWith() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        assertThat(car1.isSamePositionWith(car2)).isTrue();
        car1.moveOrNot(ALWAYS_MOVE_CONDITION);
        car2.moveOrNot(ALWAYS_MOVE_CONDITION);
        assertThat(car1.isSamePositionWith(car2)).isTrue();
        car2.moveOrNot(ALWAYS_MOVE_CONDITION);
        assertThat(car1.isSamePositionWith(car2)).isFalse();
    }
}
