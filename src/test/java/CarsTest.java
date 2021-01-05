import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarsTest {
    @Test
    public void countTest(){
        Cars cars = new Cars("jon,snow,danial");
        assertEquals(cars.getCount(), 3);
    }
}
