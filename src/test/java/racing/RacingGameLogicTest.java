/*
 * File     : RacingGameLogicTest.java
 * Date     : 2021. 01. 05
 */
package racing;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.*;

public class RacingGameLogicTest {

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
    void repeatRace() {
        RacingGameLogic racingGame = new RacingGameLogic("pobi,crong,honux");
        final int repeatMaxNumber = 5;

        while(racingGame.checkPosition(repeatMaxNumber)) {
            racingGame.race();
        }
        assertThat(racingGame.getCarsPosition().toArray())
                .contains(repeatMaxNumber);
    }

}
