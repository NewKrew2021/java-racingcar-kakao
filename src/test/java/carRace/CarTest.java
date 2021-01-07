package carRace;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void goTest() {
        Car testCar = new Car("test");
        testCar.go(() -> true);
        testCar.go(() -> true);
        assertThat(testCar.toString()).isEqualTo("test : --");
    }

    @Test
    public void compareToTest() {
        Car testCar1 = new Car("test1");
        Car testCar2 = new Car("test2");
        testCar1.go(() -> true);
        testCar2.go(() -> true);
        testCar2.go(() -> true);
        assertThat(testCar1.compareTo(testCar2)).isLessThan(0);
    }
}
