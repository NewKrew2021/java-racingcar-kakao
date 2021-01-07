package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("Cars 객체 생성 테스트")
    public void testCreateCars(){
        Cars cars = Cars.of(Arrays.asList("pobi","crong"));
        assertThat(cars.getCars()).extracting("name").contains("pobi", "crong");

    }
    @Test
    @DisplayName("location이 가장 큰 차가 우승한다. 우승자는 여러명일 수 있다.")
    public void testFindWinners(){
        Cars cars= new Cars(Arrays.asList(
                new Car("pobi",5),
                new Car("crong",3),
                new Car("honux",5)
        ));

        assertThat(cars.findWinners()).extracting("name").contains("pobi","honux");
    }
}
