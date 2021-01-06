package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.RacingGame;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    public void stringToNames(){
        String input = "pobi,crong,honux";
        String[] names = RacingGame.stringToNames(input);
        assertThat(names).contains("pobi", "crong", "honux");
    }


    @Test
    public void testMakeCars(){
        String input = "pobi,crong";
        String[] names = RacingGame.stringToNames(input);
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
