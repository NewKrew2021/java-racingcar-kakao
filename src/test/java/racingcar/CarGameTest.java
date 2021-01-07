package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarGameTest {

    @DisplayName("차량의 이름과 그 차량의 위치가 주어졌을 때, 승리한 차량 배열을 만든다.")
    @Test
    void getWinnerTest() {
        Cars cars = new Cars();
        cars.add(Car.of("hendo", 10));
        cars.add(Car.of("brody", 5));
        cars.add(Car.of("corby", 6));
        CarGame game = CarGame.of(cars, 3);
        assertThat(game.getWinner()).containsOnly("hendo");
    }

}
