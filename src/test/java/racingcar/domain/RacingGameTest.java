package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.view.RacingGameInput;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {

    @Test
    public void testMakeCars(){
        String input = "pobi,crong";
        String[] names = RacingGameInput.stringToNames(input);
        RacingGame racing = new RacingGame(names);
        assertThat(racing.getCars()).extracting("name").contains("pobi", "crong");
    }

    @Test
    public void testWinner(){
        String[] names = {"pobi", "crong", "honux"};
        int[] locations = {5, 3, 5};
        RacingGame racing = new RacingGame(names, locations);

        assertThat(racing.getWinners()).contains("pobi","honux");
    }

}
