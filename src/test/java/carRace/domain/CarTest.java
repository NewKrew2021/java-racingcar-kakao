package carRace.domain;

import carRace.dtos.CarDTO;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void getNameTest() {
        Car car = new Car("holly");
        assertThat(car.getName()).isEqualTo("holly");
    }

    @Test
    public void getLocationTest() {
        Car car = new Car("mother", 123);
        assertThat(car.getLocation()).isEqualTo(123);
    }

    @Test
    public void getDTOTest() {
        Car car = new Car("jolly", 123);
        assertThat(car.getDTO()).isEqualTo(
                new CarDTO("jolly", 123)
        );
    }

    @Test
    public void judgeAndGo_Test1() {
        Car car = new Car("mother");
        car.judgeAndGo(3);
        assertThat(car.getLocation()).isEqualTo(0);
    }

    @Test
    public void judgeAndGo_Test2() {
        Car car = new Car("mother");
        car.judgeAndGo(4);
        assertThat(car.getLocation()).isEqualTo(1);
    }
}