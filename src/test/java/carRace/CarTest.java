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
}
