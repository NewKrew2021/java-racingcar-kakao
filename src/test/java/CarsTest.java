import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarsTest {
    @Test
    public void countTest(){
        Cars cars = new Cars("jon,snow,dania");
        assertEquals(cars.getCount(), 3);
    }

    @Test
    public void checkHeads(){
        List<Car> list = new ArrayList<>();
        Car car1 = new Car("jon",1);
        Car car2 = new Car("snow", 2);
        Car car3 = new Car("dania",3);

        list.add(car1);
        list.add(car2);
        list.add(car3);

        Cars cars = new Cars(list);
        List<Car> heads = cars.getHeads();
        assertTrue(heads.get(0).equals(car3));
    }
}
