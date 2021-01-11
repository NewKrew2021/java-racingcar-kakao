package racing.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.RandomValue;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.*;

public class RacingGameLogicTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux"})
    void racingConstructorTest(final String input) {
        RacingGameLogic racingGame = new RacingGameLogic(input, 10);
        final List<String> dest = Arrays.asList(input.split(","));

        int carsSize = racingGame.getCarsSize();
        assertThat(carsSize).isEqualTo(3);

    }

    @Test
    void raceTest() {
        RacingGameLogic racingGame = new RacingGameLogic("aa,bb,cc,dd", 10);
        List<List<Boolean>> raceValues = Arrays.asList(
                Arrays.asList( true, true, true, true ),
                Arrays.asList( false, true, true, true ),
                Arrays.asList( false, false, true, true ),
                Arrays.asList( false, false, false, true )
        );
        for( List<Boolean> raceValue  : raceValues) {
            racingGame.race(raceValue);
        }
        assertThat(racingGame.getCarsPosition()).isEqualTo(Arrays.asList(1,2,3,4));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux"})
    void repeatRace(String input) {
        final int repeatMaxNumber = 5;
        RacingGameLogic racingGame = new RacingGameLogic(input, repeatMaxNumber);

        while(racingGame.checkPosition()) {
            racingGame.race(RandomValue.makeRandomValues(racingGame.getCarsSize()));
        }
        assertThat(racingGame.getCarsPosition().toArray())
                .contains(repeatMaxNumber);
    }

}
