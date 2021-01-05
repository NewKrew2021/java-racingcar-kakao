package racing;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class RacingTest {

    @Test
    void racingConstructorTest() {
        int NUMBERS = 5;
        Racing racing = new Racing(NUMBERS);
        racing.setCars("pobi,crong,honux");
        List<Car> cars = racing.getCars();
        List<String> dest = Arrays.asList("pobi", "crong", "honux");
        for (int i = 0; i < cars.size(); i++) {
            assertThat(cars.get(i).getName()).isEqualTo(dest.get(i));
        }
    }

    @Test
    void stopTest() {
        Car car = new Car("pobi");
        boolean isMoved = car.goOrStop(2);
        assertThat(isMoved).isFalse();
    }

    @Test
    void goTest() {
        Car car = new Car("pobi");
        boolean isMoved = car.goOrStop(4);
        assertThat(isMoved).isTrue();
    }

    @Test
    void moveTest() {
        Car car = new Car("pobi");
        car.move(true);
        assertThat(car.getPosition()).isEqualTo(1);
        car.move(true);
        car.move(true);
        assertThat(car.getPosition()).isEqualTo(3);
    }

    @Test
    void raceTest() {
        int NUMBERS = 5;
        Racing racing = new Racing(NUMBERS);
        racing.setCars("pobi,crong,honux");
        List<Integer> resultPosition = racing.repeatRacing();
        assertThat(resultPosition.size()).isEqualTo(racing.getCars().size());
        assertThat(resultPosition).asList()
                .contains(NUMBERS);
        for (int position : resultPosition) {
            assertThat(position).isBetween(0, NUMBERS);
        }
    }
}
