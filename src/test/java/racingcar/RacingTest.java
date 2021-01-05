package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {

    @Test
    public void winnerTest(){
        Racing rc = new Racing();
        ArrayList<Integer> arr =  new ArrayList<>();
        arr.add(2);
        assertThat(rc.getWinner(new int[]{4, 5, 6})).isEqualTo(arr);
    }



}
