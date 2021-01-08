package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.view.RacingGameInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    public void testCreateCars() {
        String input = "pobi,crong";
        List<String> names = RacingGameInput.stringToNames(input);
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        Cars carsObj = new Cars(cars);
        assertThat(carsObj.getCars()).extracting("name").contains("pobi", "crong");
    }

    @Test
    public void testGetMaxLocation() {
        Cars cars = new Cars(Arrays.asList(
                new Car("pobi", 5),
                new Car("crong", 3),
                new Car("honux", 5)));

        assertThat(cars.getMaxLocation()).isEqualTo(5);
    }

    @Test
    public void testGetCarNamesLocatedIn() {
        Cars cars = new Cars(Arrays.asList(
                new Car("pobi", 5),
                new Car("crong", 3),
                new Car("honux", 5)));

        assertThat(cars.getCarNamesLocatedIn(3)).isEqualTo(Arrays.asList("crong"));
    }
}
