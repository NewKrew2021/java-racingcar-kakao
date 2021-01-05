package carRace;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private Cars testCars;

    @BeforeEach
    public void setUp() {
        String[] testNames = {"car1", "car2", "car3", "car4"};
        testCars = new Cars(testNames);
    }

    @Test
    public void toStringTest() {
        List<Integer> numbers = Arrays.asList(0, 3, 4, 9);
        testCars.moveAllCars(numbers);
        String expectedString = "car1 : \ncar2 : \ncar3 : -\ncar4 : -\n";
        assertThat(testCars.toString()).isEqualTo(expectedString);
    }
}
