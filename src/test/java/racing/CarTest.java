/*
 * File     : CarTest.java
 * Date     : 2021. 01. 05
 */
package racing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.Car;

/*
 * Class    : CarTestClass
 * Version  : 1.1
 * author   : eli.nabro
 *
 * Car class for testing
 */
import static org.assertj.core.api.AssertionsForClassTypes.*;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi"})
    void moveTest(String input) {
        Car car = new Car(input);

        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
        car.move();
        car.move();
        assertThat(car.getPosition()).isEqualTo(3);
    }

}
