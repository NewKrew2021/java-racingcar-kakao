package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {

    Racing rc;

    @BeforeEach
    public void setup(){
        this.rc = new Racing();
    }

    @Test
    public void getFinalCarPositionsTest(){
        Car car1 = new Car("a");
        Car car2 = new Car("b");
        Car car3 = new Car("c");
        ArrayList<Car> cars = new ArrayList<>(Arrays.asList(car1, car2, car3));
        cars.get(1).move(5);
        assertThat(rc.getFinalCarPositions(cars)).isEqualTo(new ArrayList<Integer>(Arrays.asList(0,1,0)));
    }

    @Test
    public void getWinnerNameTest(){
        Car car1 = new Car("a");
        Car car2 = new Car("b");
        Car car3 = new Car("c");
        ArrayList<Car> cars = new ArrayList<>(Arrays.asList(car1, car2, car3));
        cars.get(1).move(5);
        assertThat(rc.getWinnerName(cars)).isEqualTo(new ArrayList<String>(Arrays.asList("b")));

    }

    @Test
    public void getRandomIntegerTest(){
        assertThat(rc.getRandomInteger(0,9)).isBetween(0,9);
    }

    @Test
    public void checkCarNamesTest(){
        ArrayList<String> arr1 = new ArrayList<>(Arrays.asList("12345","123","123"));
        assertThat(rc.checkCarNames(arr1)).isTrue();

        ArrayList<String> arr2 = new ArrayList<>(Arrays.asList("123456","123","123"));
        assertThat(rc.checkCarNames(arr2)).isFalse();
    }
}
