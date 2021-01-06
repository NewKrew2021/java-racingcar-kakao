package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GameManagerTest {

    private GameManager gameManager;

    @BeforeEach
    public void setUp() {

        gameManager = new GameManager();
    }

    /*
    1. 자동차 이름 문자열은 ,로 구분된다.
    , 앞뒤의 공백은 자동으로 지워준다.
    * */
    @Test
    public void testCarName() {

        String userInput = "pobi,crong,honux, teo ";
        List<String> result = gameManager.parsing(userInput);
        Assertions.assertThat(result)
                .containsAll(Arrays.asList("pobi", "crong", "honux", "teo"));
    }


}
