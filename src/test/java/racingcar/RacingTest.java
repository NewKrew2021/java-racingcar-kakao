package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {

//    @Test
//    public void raceTest() {
//        Racing race = new Racing();
//        List<String> name = new ArrayList<>(Arrays.asList("mac", "book", "pro"));
//        race.registerCars(name);
//        race.setRound(5);
//        assertThat()
//    }

    @Test
    public void winnerTestDraw(){
        Racing race = new Racing();
        List<String> name = new ArrayList<>(Arrays.asList("mac", "book", "pro"));
        race.registerCars(name);
        race.setRound(0);
        race.race();
        List<Integer> arr = new ArrayList<>(Arrays.asList(0, 1, 2));
        assertThat(race.winnerCarIndex()).isEqualTo(arr);
    }

//    @Test
//    public void winnerTestTwo() {
//        Racing rc = new Racing();
//        rc.startRacing(3, 0);
//        rc.cars.get(0).move(5);
//        rc.cars.get(2).move(5);
//        List<Integer> arr = new ArrayList<>(Arrays.asList(0, 2));
//        assertThat(rc.whoWinner()).isEqualTo(arr);
//    }
//
//    @Test
//    public void startRacingTest(){
//        Racing rc = new Racing();
//        rc.startRacing(3,0);
//        ArrayList<Integer> arr = new ArrayList<>();
//        arr.add(0);
//        arr.add(0);
//        arr.add(0);
//        assertThat(rc.finalCarPositions()).isEqualTo(arr);
//    }
}
