package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(Arrays.asList("mac", "book", "pro"));
    }

    @Test
    public void create() {
        assertThat(cars).isEqualTo(new Cars(Arrays.asList("mac", "book", "pro")));
    }

    @Test
    public void getCarsList() {
        assertThat(cars.getCars()).isEqualTo(Arrays.asList(
                new Car("mac"),
                new Car("book"),
                new Car("pro")
        ));
    }

    @Test
    public void moveCar() {
        cars.move(() -> true);
        assertThat(cars.getCars().get(0).getPosition()).isEqualTo(1);
    }

    @Test
    public void moveNoCar() {
        cars.move(() -> false);
        assertThat(cars.getCars().get(0).getPosition()).isEqualTo(0);
    }

    @Test
    public void winnersName() {
        cars.getCars().get(0).move(true);
        cars.getCars().get(2).move(true);
        assertThat(cars.getWinnerNames()).isEqualTo(Arrays.asList("mac", "pro"));
    }
}