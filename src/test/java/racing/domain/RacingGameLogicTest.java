/*
 * File     : RacingGameLogicTest.java
 * Date     : 2021. 01. 05
 */
package racing.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.Car;
import racing.domain.RacingGameLogic;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.*;

/*
 * Class    : RandomGameLogicTestClass
 * Version  : 1.1
 * author   : eli.nabro
 *
 * Random Game Logic class for testing
 */
public class RacingGameLogicTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux"})
    void racingConstructorTest(final String input) {
        RacingGameLogic racingGame = new RacingGameLogic(input);
        final List<String> dest = Arrays.asList(input.split(","));

        List<Car> cars = racingGame.getCars();

        for (int i = 0; i < cars.size(); i++) {
            assertThat(cars.get(i).getName()).isEqualTo(dest.get(i));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux"})
    void repeatRace(String input) {
        RacingGameLogic racingGame = new RacingGameLogic(input);
        final int repeatMaxNumber = 5;

        while(racingGame.checkPosition(repeatMaxNumber)) {
            racingGame.race();
        }
        assertThat(racingGame.getCarsPosition().toArray())
                .contains(repeatMaxNumber);
    }

}
