package racingcar.view;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingGameInputTest {
    private RacingGameInput game = new RacingGameInput();

    @Test
    public void testStringToNames(){
        String input = "pobi,crong,honux";
        List<String> names = game.stringToNames(input);
        assertThat(names).contains("pobi", "crong", "honux");
    }

    @Test
    public void testInputIsEmpty(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String input = "";
            game.stringToNames(input);
        });

    }

    @Test
    public void testCheckNameLength(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String input = "carname";
            game.checkNameLength(input);
        });
    }
}
