package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    public void findWinners(){
        Cars cars = new Cars(
                Arrays.asList(
                        new Car("name1",0), new Car("name2",3), new Car("name3",3)));
        List<Car> winnerCars = cars.getWinner();
        assertThat(winnerCars).isEqualTo(
                Arrays.asList(
                        new Car("name2",3), new Car("name3",3)));
    }

    @Test
    public void getWinnerNameTest(){
        Cars cars = new Cars(
                Arrays.asList(
                        new Car("name1",0), new Car("name2",3), new Car("name3",3)));
        List<String> winnerCarsNames = cars.getWinnerName();
        assertThat(winnerCarsNames).isEqualTo(Arrays.asList("name2", "name3"));
    }
}
