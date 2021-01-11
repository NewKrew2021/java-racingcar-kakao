package carracing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    Cars cars;

    @BeforeEach
    void setUp(){
        cars = Cars.makeNewCars_cars(Arrays.asList(new Car("car1", 2), new Car("car2", 1)));
    }

    @Test
    void listOfTextCarsTest(){
        cars = Cars.makeNewCars_text(Arrays.asList("c1"));
        assertThat(cars.getCars().get(0).getName()).isEqualTo("c1");
    }

    @Test
    void no2Test(){
        assertThat(cars.getCars().get(1).getName()).isEqualTo("car2");
    }

    @Test
    void winnerTest(){
        assertThat(cars.selectRaceWinners().getCars().get(0).getName()).isEqualTo("car1");
    }
}
