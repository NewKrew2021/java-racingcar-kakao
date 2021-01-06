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
    void splitTest() {
        racingGame.race();
        List<Car> carInfos = racingGame.getRaceStatus();
        List<String> carNames = carInfos.stream().map(Car::getName).collect(Collectors.toList());
        assertThat(carNames).containsExactly("dino", "yell", "pobi");
    }



}
