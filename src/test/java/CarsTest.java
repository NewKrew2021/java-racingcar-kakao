import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    void cars() {
        Cars cars = new Cars();
        cars.push(new Car("pobi"));
        cars.push(new Car("honux"));
        cars.push(new Car("crong"));

        List<String> carNames = cars.getCars()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        assertThat(carNames).isEqualTo(Arrays.asList("pobi", "honux", "crong"));
    }

    @Test
    void winners() {
        Cars cars = new Cars();
        Car loser1 = new Car("lose1", 1);
        Car loser2 = new Car("lose2", 2);
        Car winner1 = new Car("win1", 3);
        Car winner2 = new Car("win2", 3);
        cars.push(loser1);
        cars.push(loser2);
        cars.push(winner1);
        cars.push(winner2);

        List<String> winnerNames = cars.findWinners()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        assertThat(winnerNames).isEqualTo(Arrays.asList("win1", "win2"));
    }

    @Test
    void createByNames(){
        Cars cars = new Cars();
        cars.createCarsByNames(Arrays.asList("danny","corby","joy"));
        assertThat(cars.getCars()).extracting(Car::getName)
                .isEqualTo(Arrays.asList("danny","corby","joy"));
    }
}