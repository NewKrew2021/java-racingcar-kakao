package racingcar.domain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingGame;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame("d,b,v");
    }

    @Test
    void splitTest(){
        racingGame.racing();
        List<CarInfo> carInfos = racingGame.getStatus();
        List<String> carNames = carInfos.stream().map(CarInfo::getName).collect(Collectors.toList());
        assertThat(carNames).containsExactly("d","b","v");
    }

    @Test
    void splitUnderFiveTest(){
        racingGame = new RacingGame("abcdef,a,b");
        racingGame.racing();
        List<CarInfo> carInfos = racingGame.getStatus();
        List<String> carNames = carInfos.stream().map(CarInfo::getName).collect(Collectors.toList());
        List<Integer> carPositions = carInfos.stream().map(CarInfo::getPosition).collect(Collectors.toList());
        assertThat(carNames).containsExactly("a","b");
    }

    @Test
    void singleWinnerTest() {
        Car car1 = new Car("yell");
        Car car2 = new Car("dino");
        Car car3 = new Car("pobi");

        car1.nextStep();
        racingGame = new RacingGame(Arrays.asList(car1, car2, car3));

        assertThat(racingGame.findWinners()).containsExactly("yell");
    }

    @Test
    void multiWinnersTest(){
        Car car1 = new Car("yell");
        Car car2 = new Car("dino");
        Car car3 = new Car("pobi");

        car1.nextStep(); car3.nextStep();
        racingGame = new RacingGame(Arrays.asList(car1, car2, car3));

        assertThat(racingGame.findWinners()).containsExactly("yell", "pobi");
    }

    @Test
    void carGoTest() {
        assertThat(racingGame.isCarGo(0)).isEqualTo(false);
        assertThat(racingGame.isCarGo(3)).isEqualTo(false);
        assertThat(racingGame.isCarGo(4)).isEqualTo(true);
        assertThat(racingGame.isCarGo(9)).isEqualTo(true);
    }

}
