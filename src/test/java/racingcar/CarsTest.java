package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @DisplayName("차량의 이름들 주어지면, 그것을 통해 차량으로 구성된 리스트를 구성한다.")
    @Test
    public void create() {
        //given
        List<String> carNames = new ArrayList<>();
        carNames.add("hendo");
        carNames.add("brody");
        carNames.add("corby");

        //when
        Cars cars = new Cars(carNames);
        //then
        List<Car> expected = new ArrayList<>();
        expected.add(Car.of("hendo", 0));
        expected.add(Car.of("brody", 0));
        expected.add(Car.of("corby", 0));

        assertThat(cars.getCars()).isEqualTo(expected);
    }

}
