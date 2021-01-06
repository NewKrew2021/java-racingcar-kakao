package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarGameTest {

    @Test
    void playRoundTest(){
        ArrayList<Car> carList = new ArrayList<>(Arrays.asList(Car.of("hendo", 5), Car.of("brody", 3)));
        CarGame game = CarGame.of(carList, 3);
        while(!game.isFinished()){
            game.playRound();
        }
        assertThat(game.isFinished()).isEqualTo(true);
    }

    @Test
    void getWinnerTest(){
        ArrayList<Car> carList = new ArrayList<>(Arrays.asList(Car.of("hendo", 5), Car.of("brody", 3)));
        CarGame game = CarGame.of(carList,3);
        assertThat(game.getWinner()).containsOnly("hendo");
    }

}
