import domain.Car;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameTest {

    @Test
    void createCars() {
        RacingGame game = new RacingGame(3, "pobi,crong,honux");
        assertThat(game.getCars())
                .isEqualTo(Arrays.asList(
                        new Car("pobi"),
                        new Car("crong"),
                        new Car("honux")
                ));
    }

    @Test
    void isGameEnd() {
        RacingGame game = new RacingGame(3, "pobi,crong,honux");
        game.playRound();
        game.playRound();
        game.playRound();

        assertThat(game.isEnd()).isTrue();
    }
}
