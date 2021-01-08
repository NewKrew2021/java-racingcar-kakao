package racingcar.domain;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    public void findWinners(){

        List<Car> carList = new ArrayList<>(Arrays.asList(
                new Car("name1",0), new Car("name2",3), new Car("name3",3)));
        Cars cars = new Cars(carList);
        List<Car> winnerCars = cars.getWinner();
        assertThat(winnerCars).isEqualTo(
                Arrays.asList(
                        carList.get(1), carList.get(2)));
    }

    @Test
    public void findWinnerNameTest(){
        List<Car> carList = new ArrayList<>(Arrays.asList(
                new Car("name1",0), new Car("name2",3), new Car("name3",3)));
        Cars cars = new Cars(carList);
        List<String> winnerCarsName = cars.getWinnerName();
        assertThat(winnerCarsName).isEqualTo(
                Arrays.asList(
                        "name2", "name3"));
    }
}
