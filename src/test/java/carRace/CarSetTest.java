package carRace;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarSetTest {

    private CarSet testCarSet;

    @BeforeEach
    public void setUp() {
        String[] testNames = {"car1", "car2", "car3", "car4"};
        testCarSet = new CarSet(testNames);
    }

    @Test
    public void toStringTest() {
        List<Integer> numbers = Arrays.asList(0, 3, 4, 9);
        testCarSet.moveAllCars(numbers);
        String expectedString = "car1 : \ncar2 : \ncar3 : -\ncar4 : -\n";
        assertThat(testCarSet.toString()).isEqualTo(expectedString);
    }

    @Test
    public void getWinners(){
        /* phase 1 (0, 0, 1, 1)*/
        List<Integer> numbers1 = Arrays.asList(0, 3, 4, 9);
        testCarSet.moveAllCars(numbers1);

        /* phase 2 (0, 1, 1, 1)*/
        List<Integer> numbers2 = Arrays.asList(0, 4, 3, 2);
        testCarSet.moveAllCars(numbers2);

        /* phase 3 (1, 1, 2, 2)*/
        List<Integer> numbers3 = Arrays.asList(4, 3, 6, 9);
        testCarSet.moveAllCars(numbers3);

        List<Car> winners = testCarSet.getWinners();

        String expectedString = "[car3 : --, car4 : --]";
        assertThat(winners.toString()).isEqualTo(expectedString);
    }
}