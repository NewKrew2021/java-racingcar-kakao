package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    public void testCreateCars(){
        Cars cars = new Cars(Arrays.asList(
                new Car("pobi"),
                new Car("crong")
        ));
        assertThat(cars.getCars()).extracting("name").contains("pobi", "crong");

    }
    @Test
    public void testFindWinners(){
        Cars cars= new Cars(Arrays.asList(
                new Car("pobi",5),
                new Car("crong",3),
                new Car("honux",5)
        ));

        assertThat(cars.findWinners()).extracting("name").contains("pobi","honux");
    }
}
