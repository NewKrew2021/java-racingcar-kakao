package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarGameTest {

    @Test
    void playRoundTest(){
        ArrayList<Car> carList = new ArrayList<Car>(Arrays.asList(new Car("hendo", 5), new Car("brody", 3)));
        CarGame game = new CarGame(carList, 3);
        while(!game.isFinished()){
            game.playRound();
        }
        assertThat(game.isFinished()).isEqualTo(true);
    }

    @Test
    void getWinnerTest(){
        ArrayList<Car> carList = new ArrayList<Car>(Arrays.asList(new Car("hendo", 5), new Car("brody", 3)));
        CarGame game = new CarGame(carList,3);
        assertThat(game.getWinner()).contains("hendo");
    }

}
