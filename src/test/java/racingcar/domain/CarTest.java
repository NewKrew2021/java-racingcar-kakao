package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    Car car;

    @BeforeEach
    void setInit(){
        car = new Car("kuri");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 4, 10})
    void moveTest(int moveNum){
        car.move(moveNum);
        assertThat(car.getLocation()).isEqualTo(moveNum);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 5, 6, 9})
    void getCarLocationTest(int moveNum){
        car.move(moveNum);
        assertThat(car.getCarLocations()).isEqualTo("kuri : " + "-".repeat(moveNum));
    }


}
