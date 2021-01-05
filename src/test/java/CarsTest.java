import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    void cars() {
        Cars cars = new Cars();
        cars.push(new Car("pobi"));
        cars.push(new Car("honux"));
        cars.push(new Car("crong"));

        assertThat(cars.getCars())
                .extracting(Car::getName)
                .isEqualTo(Arrays.asList("pobi", "honux", "crong"));
    }

    @Test
    void winners() {
        Car winner1 = new Car("win1");
        winner1.moveOrNot(9);
        winner1.moveOrNot(9);
        winner1.moveOrNot(9);
        Car winner2 = new Car("win2");
        winner2.moveOrNot(9);
        winner2.moveOrNot(9);
        winner2.moveOrNot(9);
        Car loser1 = new Car("lose1");
        loser1.moveOrNot(9);
        loser1.moveOrNot(9);
        Car loser2 = new Car("lose2");
        loser2.moveOrNot(9);

        Cars cars = new Cars();
        cars.push(loser1);
        cars.push(winner1);
        cars.push(loser2);
        cars.push(winner2);

        assertThat(cars.findWinners())
                .extracting(Car::getName)
                .isEqualTo(Arrays.asList("win1", "win2"));
    }

    @Test
    void createByNames(){
        Cars cars = new Cars();
        cars.createCarsByNames(Arrays.asList("danny","corby","joy"));
        assertThat(cars.getCars()).extracting(Car::getName)
                .isEqualTo(Arrays.asList("danny","corby","joy"));
    }
}