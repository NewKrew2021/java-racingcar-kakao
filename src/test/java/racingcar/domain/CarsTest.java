package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    public void findWinnerNameTest() {
        List<Car> carList = new ArrayList<>(Arrays.asList(
                new Car("name1", 0), new Car("name2", 3), new Car("name3", 3)));
        Cars cars = new Cars(carList);
        List<String> winnerCarsName = cars.getWinnerName();
        assertThat(winnerCarsName).isEqualTo(
                Arrays.asList(
                        "name2", "name3"));
    }

    @Test
    public void 차들정보불러오기Test() {
        List<Car> carList = new ArrayList<>(Arrays.asList(
                new Car("name1", 0), new Car("name2", 3), new Car("name3", 3)));
        Cars cars = new Cars(carList);
        Map<String, Integer> info = new HashMap<>();
        info.put("name1", 0);
        info.put("name2", 3);
        info.put("name3", 3);
        assertThat(cars.getCarsInfo()).isEqualTo(info);
    }

    @Test
    public void moveAllTest() {
        List<Car> carList = new ArrayList<>(Arrays.asList(
                new Car("name1", 0), new Car("name2", 3), new Car("name3", 3)));
        Cars cars = new Cars(carList);
        cars.moveAll(Arrays.asList(4, 4, 0));
        Map<String, Integer> info = new HashMap<>();
        info.put("name1", 1);
        info.put("name2", 4);
        info.put("name3", 3);
        assertThat(cars.getCarsInfo()).isEqualTo(info);

    }

}
