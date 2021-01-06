package racegame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CarsTest {

    @Test
    @DisplayName("Cars 객체로 우승자 리스트 생성 테스트")
    public void carsCreateTest() {
        Car pobi = new Car("pobi", 5);
        Car teo = new Car("teo", 8);
        Car tarkov = new Car("tarko", 8);
        Cars cars = new Cars(Arrays.asList(pobi, teo, tarkov));
        assertThat(cars.getMaxPosition()).isEqualTo(8);
    }

}
