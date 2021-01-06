/*
 * File     : RacingUITest.java
 * Date     : 2021. 01. 05
 */
package racing;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.*;

public class RacingUITest {

    @Test
    void playRacingGameTest() {
        final int NUMBERS = 5;
        RacingUI racingGame = new RacingUI();

        racingGame.setCarsName("pobi,crong,honux");
        List<Integer> resultPosition = racingGame.playRacingGame(NUMBERS);

        assertThat(resultPosition).asList()
                .contains(NUMBERS);

        for (int position : resultPosition) {
            assertThat(position).isBetween(0, NUMBERS);
        }
    }

    @Test
    void runTest() {
        String input = "pobi,crong,honux\n" + "5\n";
        RacingUI racingUI = new RacingUI(input);
        racingUI.run();
    }

}
