package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarGameTest {
    @Test
    void parseCarNameTest(){
        String text = "hendo,brody,summer";
        ArrayList<String> nameList = CarGame.parseCarName(text);
        assertThat(nameList).contains("hendo").contains("brody").contains("summer");
    }

    @Test
    void validateCarNameTest(){
        assertThatThrownBy(() -> {
            String text = "hendooo,brody,summer";
            ArrayList<String> nameList = CarGame.parseCarName(text);
            CarGame.validateCarName(nameList);
        });
    }

    @Test
    void playRoundTest(){
        ArrayList<Car> carList = new ArrayList<Car>(Arrays.asList(new Car("hendo", 5), new Car("brody", 3)));
        CarGame game = new CarGame(carList, 3);
        game.playRound();
        assertThat(game.isFinished()).isEqualTo(true);
    }

    @Test
    void getWinnerTest(){
        ArrayList<Car> carList = new ArrayList<Car>(Arrays.asList(new Car("hendo", 5), new Car("brody", 3)));
        CarGame game = new CarGame(carList,3);
        assertThat(game.getWinner()).contains("hendo");
    }

}
