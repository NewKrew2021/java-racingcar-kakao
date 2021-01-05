package racingcar.domain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame("dino,yell,pobi");
    }

    @Test
    void splitTest(){
        racingGame.race();
        List<CarInfo> carInfos = racingGame.getRaceStatus();
        List<String> carNames = carInfos.stream().map(CarInfo::getName).collect(Collectors.toList());
        assertThat(carNames).containsExactly("dino","yell","pobi");
    }

    @Test
    void splitUnderFiveTest(){
        racingGame = new RacingGame("dinobin,yell,pobi");
        racingGame.race();
        List<CarInfo> carInfos = racingGame.getRaceStatus();
        List<String> carNames = carInfos.stream().map(CarInfo::getName).collect(Collectors.toList());
        assertThat(carNames).containsExactly("yell","pobi");
    }


    @Test
    void carGoTest() {
        assertThat(racingGame.isCarGo(0)).isEqualTo(false);
        assertThat(racingGame.isCarGo(3)).isEqualTo(false);
        assertThat(racingGame.isCarGo(4)).isEqualTo(true);
        assertThat(racingGame.isCarGo(9)).isEqualTo(true);
    }

}
