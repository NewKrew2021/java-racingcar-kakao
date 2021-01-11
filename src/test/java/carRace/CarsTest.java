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
    @DisplayName("가장 많은 거리를 이동한 우승자를 구한다.")
    public void getWinnersTest() {
        assertThat(testCars.getWinners()).containsExactly(testCar1, testCar4);
    }

    @Test
    @DisplayName("차들의 이름과 위치를 문자열로 반환한다.")
    public void toStringTest() {
        String expected = "car1 : --\n" +
                "car2 : -\n" +
                "car3 : \n" +
                "car4 : --\n";
        assertThat(testCars.toString()).isEqualTo(expected);
    }
}
