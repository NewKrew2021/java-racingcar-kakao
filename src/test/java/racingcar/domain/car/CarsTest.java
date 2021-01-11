package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class CarsTest {

    @DisplayName("자동차를 가지는 리스트를 테스트한다.")
    @Test
    public void create() {
        //given
        List<Car> newCars = new ArrayList<>(Arrays.asList(Car.of("hendo", 10),
                Car.of("brody", 33), Car.of("corby", 12)));
        Cars cars = new Cars(newCars);
        //then
        assertThat(cars).extracting("Cars").usingRecursiveComparison().isEqualTo(newCars);
    }

    @DisplayName("현재 차량들의 상태가 주어졌을 때, 가장 앞에있는 차의 이름를 반환한다.")
    @Test
    public void getFarthestCarNamesTest() {
        //given
        Cars testCars = new Cars(new ArrayList<>(Arrays.asList(Car.of("hendo", 10),
                Car.of("brody", 33), Car.of("corby", 12))));
        //when
        List<String> winCars = testCars.getFarthestCarNames();
        //then
        assertThat(winCars).containsExactly("brody");
    }

}
