package racingcar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    void winnerTest(){
        racingGame.racing();
        assertThat(racingGame.findWinners()).containsExactly("d","b","v");
    }

    @Test
    void carGoTest() {
        assertThat(racingGame.isCarGo(0)).isEqualTo(false);
        assertThat(racingGame.isCarGo(3)).isEqualTo(false);
        assertThat(racingGame.isCarGo(4)).isEqualTo(true);
        assertThat(racingGame.isCarGo(9)).isEqualTo(true);
    }

}
