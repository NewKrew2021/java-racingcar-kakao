package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarGameTest {

    @Test
    @DisplayName("정해진 횟수만큼 라운드가 진행되면 isFinished가 true가 되는지 확인한다.")
    void playRoundTest(){
        List<String> names = new ArrayList<String>(Arrays.asList("hendo", "brody"));
        CarGame game = new CarGame(names, 1);
        game.playRound();
        assertThat(game.isFinished()).isEqualTo(true);
    }

}
