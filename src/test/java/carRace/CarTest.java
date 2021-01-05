package carRace;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private final int MOVE = 4;
    private final int NOT_MOVE = 3;

    @Test
    public void judgeAndGoTest() {
        Car testCar = new Car("test");
        testCar.judgeAndGo(MOVE);
        testCar.judgeAndGo(MOVE);
        testCar.judgeAndGo(NOT_MOVE);
        assertThat(testCar.toString()).isEqualTo("test : --");
    }

    @Test
    public void compareToTest() {
        Car testCar1 = new Car("test1");
        Car testCar2 = new Car("test2");
        testCar1.judgeAndGo(MOVE);
        testCar2.judgeAndGo(MOVE);
        testCar2.judgeAndGo(MOVE);
        assertThat(testCar1.compareTo(testCar2)).isGreaterThan(0);
    }
}
