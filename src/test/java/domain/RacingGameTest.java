package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {
    @Test
    public void numCarsTest(){
        int finalRound = 0;

        String[] empty = {};
        assertThatThrownBy(() -> new RacingGame(empty, finalRound))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("자동차는 최소 %d대 이상 필요합니다.", RacingGame.MIN_NUM_CARS));

        String[] one = {"one"};
        assertThatThrownBy(() -> new RacingGame(one, finalRound))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("자동차는 최소 %d대 이상 필요합니다.", RacingGame.MIN_NUM_CARS));
    }

    @Test
    public void carNameTest(){
        String[] names = {"alice", "bob", "charlie"};
        int finalRound = 0;

        assertThatThrownBy(() -> new RacingGame(names, finalRound))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("자동차의 이름은 최대 %d자 이내로 작성하세요.", RacingGame.MAX_LEN_NAME));
    }

    @Test
    public void getRandomNumberTest() {
        String[] names = {"pobi", "crong", "honux"};
        int finalRound = 5;
        RacingGame game = new RacingGame(names, finalRound);

        int number = game.getRandomNumber();
        assertThat(number).isBetween(RacingGame.MIN_RAND_NUMBER, RacingGame.MAX_RAND_NUMBER);
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

    @Test
    public void unmodifiableTest() {
        String[] names = {"pobi", "crong", "honux"};
        int finalRound = 0;
        RacingGame game = new RacingGame(names, finalRound);

        List<Car> cars = game.getCars();
        assertThatThrownBy(() -> cars.add(new Car("pororo")))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}