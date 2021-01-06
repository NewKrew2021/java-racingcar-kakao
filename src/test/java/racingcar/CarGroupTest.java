package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarGroupTest {

    @Test
    @DisplayName("승리한 차 이름을 올바르게 구하는지 확인한다.")
    void getWinnerTest(){
        Car hendoCar = new Car("hendo", 5);
        Car brodyCar = new Car("brody", 3);
        List<Car> carList = new ArrayList<Car>(Arrays.asList(hendoCar, brodyCar));
        CarGroup carGroup = new CarGroup(carList);
        assertThat(carGroup.getWinnerName()).containsOnly("hendo");
    }

}
