package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    private Cars cars;

    @Test
    void splitTest(){
        cars = new Cars("d,b,v");
        List<CarInfo> carInfos = cars.getCarInfos();
        List<String> carNames = carInfos.stream().map(CarInfo::getName).collect(Collectors.toList());
        assertThat(carNames).containsExactly("d","b","v");
    }

    @ParameterizedTest
    @DisplayName("공백, 6글자 이상의 문자에서의 오류 테스트")
    @ValueSource(strings = {"", "LONGCAR", "LONG,LONGC,LONGCA", "LONG,,LONG"})
    void invalidCarNameTest(String carNames){
        assertThatThrownBy(()->{
            new RacingGame(carNames);
        }).isInstanceOf(InvalidCarNameException.class);
    }
}
