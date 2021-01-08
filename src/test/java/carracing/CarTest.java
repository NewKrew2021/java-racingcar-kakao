package carracing;

import carracing.domain.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    Car car;

    @BeforeEach
    void setUp(){
        car = new Car("car1", 2);
    }

    @Test
    void generateCar(){
        assertThat(car.getName()).isEqualTo("car1");
    }

    @Test
    void positionTest(){
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    void carNameLengthTest(){
        assertThatThrownBy(() ->{
            new Car("car2car3");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void carNameBlankTest(){
        assertThatThrownBy(() ->{
            new Car("");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void goTest(){
        assertThat(new Car("car1", 2).go()).isEqualTo(3);
    }
}
