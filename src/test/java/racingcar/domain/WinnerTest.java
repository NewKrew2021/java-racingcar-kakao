package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {

    private Winners winners;

    @Test
    void singleWinnerTest() {
        Car car1 = new Car("yell", 1);
        Car car2 = new Car("dino", 6);
        Car car3 = new Car("pobi", 0);

        winners = new Winners(Arrays.asList(car1, car2, car3));
        assertThat(winners.findWinners()).containsExactly("dino");
    }

    @Test
    void multiWinnersTest(){
        Car car1 = new Car("yell", 3);
        Car car2 = new Car("dino", 1);
        Car car3 = new Car("pobi", 3);

        winners = new Winners(Arrays.asList(car1, car2, car3));
        assertThat(winners.findWinners()).containsExactly("yell", "pobi");
    }
}
