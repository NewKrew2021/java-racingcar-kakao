package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private final Car car = new Car("vroom", 0);

    @Test
    public void moveTest() {
        int number = RacingGame.MOVE_THRESHOLD;

        car.move(number);
        assertThat(car.getPosition()).isEqualTo(0);

        car.move(number+1);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}