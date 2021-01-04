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
        String input = "";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String[] names = RacingGame.stringToNames(input);
        });

    }


}
