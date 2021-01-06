import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameTest {

    @Test
    public void isGameEnd() {
        Cars cars = new Cars(Arrays.asList(
                new Car("pobi"),
                new Car("crong"),
                new Car("honux"))
        );
        RacingGame game = new RacingGame(3, cars);

        game.playRound();
        game.playRound();
        game.playRound();
        assertThat(game.isEnd()).isTrue();
    }
}
