package carRace;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private final int MOVE = 4;
    private final int NOT_MOVE = 3;

    private Cars testCars;

    private Cars expectedCars;
    private List<Integer> moveNumbers1;
    private List<Integer> moveNumbers2;

    @BeforeEach
    public void setUp() {
        String[] testNames = {"car1", "car2", "car3", "car4"};
        testCars = Cars.fromNames(testNames);
        moveNumbers1 = Arrays.asList(MOVE, NOT_MOVE, MOVE, NOT_MOVE);
        moveNumbers2 = Arrays.asList(MOVE, NOT_MOVE, MOVE, MOVE);
    }

    @Test
    public void moveAllCarsTest() {
        testCars.moveAllCars(moveNumbers1);
        testCars.moveAllCars(moveNumbers2);
        String expected = "car1 : --\ncar2 : \ncar3 : --\ncar4 : -\n";
        assertThat(testCars.toString()).isEqualTo(expected);
    }

    @Test
    public void getWinners() {
        testCars.moveAllCars(moveNumbers1);
        testCars.moveAllCars(moveNumbers2);

        List<Car> winners = testCars.getWinners();

        String expected = "[car1 : --, car3 : --]";
        assertThat(winners.toString()).isEqualTo(expected);
    }
}