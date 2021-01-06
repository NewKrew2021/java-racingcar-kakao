/*
 * File     : CarTest.java
 * Date     : 2021. 01. 05
 */
package racing;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.*;

public class CarTest {

    @Test
    void moveTest() {
        Car car = new Car("pobi");

        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
        car.move();
        car.move();
        assertThat(car.getPosition()).isEqualTo(3);
    }

}
