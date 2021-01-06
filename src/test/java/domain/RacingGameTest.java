package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {
    @Test
    public void getRandomNumberTest() {
        String[] names = {"pobi", "crong", "honux"};
        int finalRound = 5;
        RacingGame game = new RacingGame(names, finalRound);

        int number = game.getRandomNumber();
        assertThat((number >= RacingGame.MIN_RAND_NUMBER && number <= RacingGame.MAX_RAND_NUMBER)).isTrue();
    }

    @Test
    public void isEndTest() {
        String[] names = {"pobi", "crong", "honux"};
        int finalRound = 3;
        RacingGame game = new RacingGame(names, finalRound);

        game.playRound();
        game.playRound();
        assertThat(game.isEnd()).isFalse();

        game.playRound();
        assertThat(game.isEnd()).isTrue();
    }

    @Test
    public void getWinnersTest() {
        List<Car> cars = Arrays.asList(
                new Car("pobi",   0),
                new Car("crong", 10),   // always win
                new Car("honux", 10));  // always win
        int finalRound = 0;
        RacingGame game = new RacingGame(cars, finalRound);

        while (!game.isEnd()) {
            game.playRound();
        }

        assertThat(game.getWinners()).isEqualTo(Arrays.asList("crong", "honux"));
    }
}