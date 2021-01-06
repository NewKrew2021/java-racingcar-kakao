package carRace;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void toStringTest(){
        Car testCar = new Car("test");
        testCar.judgeAndGo(5);
        testCar.judgeAndGo(6);
        testCar.judgeAndGo(1);
        assertThat(testCar.toString()).isEqualTo("test : --");
    }

    @Test
    public void compareToTest() {
        Car testCar1 = new Car("test1");
        Car testCar2 = new Car("test2");
        testCar1.judgeAndGo(5);
        testCar2.judgeAndGo(5);
        testCar2.judgeAndGo(5);
        assertThat(testCar1.compareTo(testCar2)).isGreaterThan(0);
    }
}
