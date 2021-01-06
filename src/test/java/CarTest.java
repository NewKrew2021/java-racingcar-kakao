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

    @ParameterizedTest
    @CsvSource({"0","1","2"})
    void move0(int trial) {
        Car car = new Car("danny");
        for (int i = 0; i < trial; i++) {
            car.moveOrNot(NEVER_MOVE_CONDITION);
        }

        int nowPosition = car.getPosition();

        assertThat(nowPosition).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({"0","1","2"})
    void moveForward(int trial) {
        Car car = new Car("danny");
        for (int i = 0; i < trial; i++) {
            car.moveOrNot(ALWAYS_MOVE_CONDITION);
        }

        int nowPosition = car.getPosition();

        assertThat(nowPosition).isEqualTo(trial);
    }


    @Test
    void isForwardThan() {
        Car car1 = new Car("danny");
        Car car2 = new Car("corby");
        car1.moveOrNot(ALWAYS_MOVE_CONDITION);

        boolean isForward = car1.isForwardThan(car2);

        assertThat(isForward).isTrue();
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

        boolean isSamePosition = car1.isAtSamePositionWith(car2);

        assertThat(isSamePosition).isEqualTo(car1Position == car2Position);
    }
}
