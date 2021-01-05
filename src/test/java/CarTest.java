import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private static final int NEVER_MOVE_CONDITION = Car.MOVE_THRESHOLD - 1;
    private static final int ALWAYS_MOVE_CONDITION = Car.MOVE_THRESHOLD;

    @Test
    void length0orNull() {
        assertThatExceptionOfType(Car.InvalidCarNameException.class).isThrownBy(() -> new Car(""));
        assertThatExceptionOfType(Car.InvalidCarNameException.class).isThrownBy(() -> new Car(null));
    }

    @Test
    void length5이하() {
        Car car = new Car("12345");
        assertThat(car.getPosition()).isEqualTo(0);
        assertThat(car.getName()).isEqualTo("12345");
    }

    @Test
    void length6이상() {
        assertThatExceptionOfType(Car.InvalidCarNameException.class).isThrownBy(() -> new Car("123456"));
    }

    @Test
    void move() {
        Car car = new Car("danny");
        car.moveOrNot(NEVER_MOVE_CONDITION);
        assertThat(car.getPosition()).isEqualTo(0);
        car.moveOrNot(ALWAYS_MOVE_CONDITION);
        assertThat(car.getPosition()).isEqualTo(1);
    }


    @Test
    void isForwardThan() {
        Car car1 = new Car("danny");
        Car car2 = new Car("corby");
        car1.moveOrNot(ALWAYS_MOVE_CONDITION);
        assertThat(car1.isForwardThan(car2)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"0,0"
                ,"1,1"
                ,"1,2"
                ,"2,3"})
    void isAtSamePositionWith(int car1Position, int car2Position) {
        Car car1 = new Car("danny");
        Car car2 = new Car("corby");
        for(int i=0; i<car1Position; i++){
            car1.moveOrNot(ALWAYS_MOVE_CONDITION);
        }
        for(int i=0; i<car2Position; i++){
            car2.moveOrNot(ALWAYS_MOVE_CONDITION);
        }
        assertThat(car1.isAtSamePositionWith(car2)).isEqualTo(car1Position == car2Position);
    }
}
