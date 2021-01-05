package racing;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.*;

public class RacingGameTest {

    @Test
    void racingConstructorTest() {
        RacingGameLogic racingGame = new RacingGameLogic("pobi,crong,honux");
        final List<String> dest = Arrays.asList("pobi", "crong", "honux");

        List<Car> cars = racingGame.getCars();

        for (int i = 0; i < cars.size(); i++) {
            assertThat(cars.get(i).getName()).isEqualTo(dest.get(i));
        }
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
    void repeatRace() {
        RacingGameLogic racingGame = new RacingGameLogic("pobi,crong,honux");
        final int repeatMaxNumber = 5;

        while(racingGame.checkPosition(repeatMaxNumber)) {
            racingGame.race();
        }
        assertThat(racingGame.getCarsPosition().toArray())
                .contains(repeatMaxNumber);
    }

    @Test
    void playRacingGameTest() {
        final int NUMBERS = 5;
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
