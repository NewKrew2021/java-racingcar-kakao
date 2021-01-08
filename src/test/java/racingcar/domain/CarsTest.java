package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.view.RacingGameInput;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    public void testCreateCars(){
        String input = "pobi,crong";
        List<String> names = RacingGameInput.stringToNames(input);
        List<Car> cars = new ArrayList<>();
        for (String name: names) {
            cars.add(new Car(name));
        }
        Cars carsObj = new Cars(cars);
        assertThat(carsObj.getCars()).extracting("name").contains("pobi", "crong");
    }
}
