import domain.Car;
import org.junit.jupiter.api.Test;
import racinggame.Cars;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.*;
public class CarsTest {

    @Test
    public void moveTest(){
        List<Car> cars = Arrays.asList(
                new Car("aa"),
                new Car("bb"),
                new Car("cc")
        );

        Cars carsManager = new Cars(cars);
        carsManager.moveAll(()->true);
        for (Car car : cars){
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }
}
