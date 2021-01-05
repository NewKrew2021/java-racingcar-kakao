package domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CarTest {
    private final Car car = new Car("vroom", 0);

    @Test
    public void moveTest() {
        int number = RacingGame.MOVE_THRESHOLD;

        car.move(number);
        assertThat(car.getPosition(), is(0));

        car.move(number+1);
        assertThat(car.getPosition(), is(1));
    }
}