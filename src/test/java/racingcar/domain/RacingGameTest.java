package racingcar.domain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {

    private RacingGame racingGame;
    private static final int SPEED = 4;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame("d,b,v");
    }

    @Test
    void splitTest(){
        racingGame.racing();
        List<CarInfo> carInfos = racingGame.getCarInfos();
        List<String> carNames = carInfos.stream().map(CarInfo::getName).collect(Collectors.toList());
        assertThat(carNames).containsExactly("d","b","v");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "LONGCAR", "LONG,LONGC,LONGCA", "LONG,,LONG"})
    void invalidCarNameTest(String carNames){
        assertThatThrownBy(()->{
            new RacingGame(carNames);
        }).isInstanceOf(InvalidCarNameException.class);
    }

}
