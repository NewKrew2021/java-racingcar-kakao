package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RacingGameTest {
    @Test
    public void getRandomNumberTest() {
        String[] names = {"pobi", "crong", "honux"};
        int finalRound = 5;
        RacingGame game = new RacingGame(names, finalRound);

        int number = game.getRandomNumber();
        assertThat((number >= RacingGame.MIN_RAND_NUMBER && number <= RacingGame.MAX_RAND_NUMBER), is(true));
    }

    @Test
    public void isEndTest() {
        String[] names = {"pobi", "crong", "honux"};
        int finalRound = 3;
        RacingGame game = new RacingGame(names, finalRound);

        game.playRound();
        game.playRound();
        assertThat(game.isEnd(), is(false));

        game.playRound();
        assertThat(game.isEnd(), is(true));
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

        assertThat(game.getWinners(), is(Arrays.asList("crong", "honux")));
    }
}