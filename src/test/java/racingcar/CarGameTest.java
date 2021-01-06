package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarGameTest {

    @Test
    void playRoundTest(){
        List<String> names = new ArrayList<String>(Arrays.asList("hendo", "brody"));
        CarGame game = new CarGame(names, 1);
        game.playRound();
        assertThat(game.isFinished()).isEqualTo(true);
    }

}
