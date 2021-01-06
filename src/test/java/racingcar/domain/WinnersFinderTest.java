package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersFinderTest {

    private WinnersFinder winnersFinder = new WinnersFinder();

    @Test
    void singleWinnerTest() {
        CarInfo car1 = new CarInfo("yell", 1);
        CarInfo car2 = new CarInfo("dino", 6);
        CarInfo car3 = new CarInfo("pobi", 0);

        List<CarInfo> carInfos = Arrays.asList(car1, car2, car3);

        assertThat(winnersFinder.findWinners(carInfos)).containsExactly("dino");
    }

    @Test
    void multiWinnersTest(){
        CarInfo car1 = new CarInfo("yell", 3);
        CarInfo car2 = new CarInfo("dino", 1);
        CarInfo car3 = new CarInfo("pobi", 3);

        List<CarInfo> carInfos = Arrays.asList(car1, car2, car3);

        assertThat(winnersFinder.findWinners(carInfos)).containsExactly("yell", "pobi");
    }
}
