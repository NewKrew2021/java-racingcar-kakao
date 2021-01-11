package carRace;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
        testCar1 = Car.of("a");
        testCar2 = Car.of("b");
        testCar3 = Car.of("c");
        testCar4 = Car.of("d");

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
    @DisplayName("가장 많은 거리를 이동한 우승자를 구한다.")
    public void getWinnersTest() {
        assertThat(testCars.getWinners()).containsExactly(testCar1, testCar4);
    }

    @Test
    @DisplayName("차들의 이름과 위치를 문자열로 반환한다.")
    public void toStringTest() {
        String expected = "a : --\n" +
                "b : -\n" +
                "c : \n" +
                "d : --\n";
        assertThat(testCars.toString()).isEqualTo(expected);
    }
}
