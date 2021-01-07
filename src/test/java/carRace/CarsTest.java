package carRace;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private Cars testCars;
    private Car testCar1;
    private Car testCar2;
    private Car testCar3;
    private Car testCar4;

    @BeforeEach
    public void setUp() {
        // car1
        testCar1 = new Car("car1");
        testCar2 = new Car("car2");
        testCar3 = new Car("car3");
        testCar4 = new Car("car4");

        testCar1.go(() -> true);
        testCar1.go(() -> true);
        testCar2.go(() -> true);
        testCar4.go(() -> true);
        testCar4.go(() -> true);

        testCars = new Cars(Arrays.asList(
                testCar1,
                testCar2,
                testCar3,
                testCar4
        ));
    }

    @Test
    public void getWinnersTest() {
        assertThat(testCars.getWinners()).containsExactly(testCar1, testCar4);
    }

    @Test
    public void toStringTest() {
        String expected = "car1 : --\n" +
                "car2 : -\n" +
                "car3 : \n" +
                "car4 : --\n";
        assertThat(testCars.toString()).isEqualTo(expected);
    }
}