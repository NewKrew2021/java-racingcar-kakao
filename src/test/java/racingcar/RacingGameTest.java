package racingcar;

import calculator.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {
    @Test
    public void stringToNames(){
        String input = "pobi,crong,honux";
        String[] names = RacingGame.stringToNames(input);
        assertThat(names).contains("pobi", "crong", "honux");
    }

    @Test
    public void testInputIsEmpty(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String input = "";
            String[] names = RacingGame.stringToNames(input);
        });

    }

    @Test
    public void testMakeCars(){
        RacingGame racing = new RacingGame();
        String input = "pobi,crong";
        String[] names = racing.stringToNames(input);
        racing.makeCars(names);
        assertThat(racing.cars).extracting("name").contains("pobi", "crong");
    }

    @Test
    public void testCheckNameLength(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            RacingGame racing = new RacingGame();
            String input = "carname";
            racing.checkNameLength(input);
        });
    }


}
