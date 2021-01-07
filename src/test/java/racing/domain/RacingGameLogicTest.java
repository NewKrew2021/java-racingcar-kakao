package racing.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.*;

public class RacingGameLogicTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux"})
    void racingConstructorTest(final String input) {
        RacingGameLogic racingGame = new RacingGameLogic(input, 10);
        final List<String> dest = Arrays.asList(input.split(","));

        List<Car> cars = racingGame.getCars();

        for (int i = 0; i < cars.size(); i++) {
            assertThat(cars.get(i).getName()).isEqualTo(dest.get(i));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux"})
    void repeatRace(String input) {
        final int repeatMaxNumber = 5;
        RacingGameLogic racingGame = new RacingGameLogic(input, repeatMaxNumber);

        while(racingGame.checkPosition()) {
            racingGame.race();
        }
        assertThat(racingGame.getCarsPosition().toArray())
                .contains(repeatMaxNumber);
    }

}
