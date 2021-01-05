package racing;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.*;

public class RacingGameTest {

    @Test
    void racingConstructorTest() {
        RacingGameLogic racing = new RacingGameLogic();
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
        boolean isMoved = car.decideGoOrStop(2);
        assertThat(isMoved).isFalse();
    }

    @Test
    void goTest() {
        Car car = new Car("pobi");
        boolean isMoved = car.decideGoOrStop(4);
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
    void playRacingGameTest() {
        int NUMBERS = 5;
        RacingGameUI racingGame = new RacingGameUI();
        racingGame.setCarsName("pobi,crong,honux");
        List<Integer> resultPosition = racingGame.playRacingGame(NUMBERS);
        assertThat(resultPosition).asList()
                .contains(NUMBERS);
        for (int position : resultPosition) {
            assertThat(position).isBetween(0, NUMBERS);
        }
    }
}
