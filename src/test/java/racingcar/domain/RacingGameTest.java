package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.view.RacingGameInput;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {

    @Test
    public void testWinner(){
        String[] names = {"pobi", "crong", "honux"};
        int[] locations = {5, 3, 5};
        RacingGame racing = new RacingGame(names, locations);

        assertThat(racing.getWinners()).contains("pobi","honux");
    }

}
