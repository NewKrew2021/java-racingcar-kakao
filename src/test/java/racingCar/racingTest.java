package racingCar;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class racingTest {

    private GameManager gameManager;

    @BeforeEach
    public void setUp() {
        gameManager = new GameManager();
    }

    /*
    1. 자동차 이름 문자열은 ,로 구분된다.
    , 앞뒤의 공백은 자동으로 지워준다.
    * */
    @Test
    public void carNameTest() {
        // given
        String userInput = "pobi,crong,honux, teo ";

        // when
        List<String> parsedName = gameManager.parsing(userInput);

        // then
        Assertions.assertThat(parsedName)
                .containsAll(Arrays.asList("pobi", "crong", "honux", "teo"));
    }

    @Test
    public void longNameExceptionTest() {
        // given
        String userInput = "bmoadv,pobi,vavaa";

        // when, then
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> gameManager.parsing(userInput));
    }

    /*
     * 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
     * */
    @Test
    public void forwardTest() {
        // given
        Car car = new Car("TestCar");

        // when
        car.goForward(4);
        car.goForward(3);
        car.goForward(9);

        // then
        Assertions.assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    public void singleWinnerTest() {
        // given
        int[] fixedNumber = {1, 2, 3, 6};
        List<Car> cars = gameManager.makeCarList(Arrays.asList("pobi", "crong", "honux", "teo"));

        // when
        for (int i = 0; i < 12; i++) {
            cars.get(i % 4).goForward(fixedNumber[i % 4]);
        }

        // then
        List<String> actualWinner = gameManager.getWinner(cars).stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        List<String> expectedWinner = Arrays.asList("teo");
        Assertions.assertThat(actualWinner).isEqualTo(expectedWinner);
    }

    @Test
    public void multiWinnerTest() {
        // given
        int[] fixedNumber = {5, 2, 3, 6};
        List<Car> cars = gameManager.makeCarList(Arrays.asList("pobi", "crong", "honux", "teo"));

        // when
        for (int i = 0; i < 12; i++) {
            cars.get(i % 4).goForward(fixedNumber[i % 4]);
        }

        // then
        List<String> actualWinners = gameManager.getWinner(cars).stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        List<String> expectedWinners = Arrays.asList("pobi", "teo");
        Assertions.assertThat(actualWinners).isEqualTo(expectedWinners);
    }

}
