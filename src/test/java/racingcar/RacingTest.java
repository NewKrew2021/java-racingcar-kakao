package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {

    @Test
    public void raceThreeCars() {

    }

    @Test
    public void winnerTestOne(){
        Racing rc = new Racing();
        rc.startRacing(3, 0);
        rc.cars.get(0).move(5);

        List<Integer> arr =  new ArrayList<>(Arrays.asList(0));
        assertThat(rc.getWinner()).isEqualTo(arr);



        Racing rc2 = new Racing();
        rc.startRacing(3, 0);
        rc.cars.get(2).move(5);

        List<Integer> arr2 =  new ArrayList<>(Arrays.asList(2));
        assertThat(rc.getWinner()).isEqualTo(arr2);
    }

    @Test
    public void winnerTestTwo() {
        Racing rc = new Racing();
        rc.startRacing(3, 0);
        rc.cars.get(0).move(5);
        rc.cars.get(2).move(5);
        List<Integer> arr = new ArrayList<>(Arrays.asList(0, 2));
        assertThat(rc.getWinner()).isEqualTo(arr);
    }

    @Test
    public void startRacingTest(){
        Racing rc = new Racing();
        rc.startRacing(3,0);
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(0);
        arr.add(0);
        assertThat(rc.getFinalCarPositions()).isEqualTo(arr);
    }




}
