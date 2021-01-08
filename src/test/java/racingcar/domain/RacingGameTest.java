package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {

    @Test
    public void testWinner(){
        List<String> names = new ArrayList<>(Arrays.asList("pobi", "crong", "honux"));
        List<Integer> locations = new ArrayList<>(Arrays.asList(5,3,5));
        RacingGame racing = new RacingGame(names, locations);

        assertThat(racing.getWinners()).contains("pobi","honux");
    }

}
