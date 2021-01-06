import domain.Car;
import org.junit.jupiter.api.Test;
import racinggame.Cars;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
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

    @Test
    public void getHeadsTest(){
        List<Car> cars = Arrays.asList(
                new Car("aa",1),
                new Car("bb",2),
                new Car("cc",2)
        );

        Cars carsManager = new Cars(cars);
        List<Car> maxs = carsManager.getHeads();
        assertEquals(maxs.contains(new Car("bb",2)), true);
        assertEquals(maxs.contains(new Car("cc",2)), true);
        assertEquals(maxs.contains(new Car("aa",1)), false);
    }
}
