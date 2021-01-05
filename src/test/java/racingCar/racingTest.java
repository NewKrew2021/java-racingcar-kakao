package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
        String userInput = "pobi,crong,honux, teo ";
        List<String> result = gameManager.parsing(userInput);
        Assertions.assertThat(result)
                .containsAll(Arrays.asList("pobi", "crong", "honux", "teo"));
    }

    @Test
    public void longNameExceptionTest() {
        String userInput = "bmoadv,pobi,vavaa";
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> gameManager.parsing(userInput));
    }

    /*
     * 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
     * */
    @Test
    public void forwardTest() {
        Car car = new Car("TestCar");
        car.goForward(4);
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
        car.goForward(3);
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
        car.goForward(9);
        Assertions.assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    public void winnerTest() {
        List<Car> cars = gameManager.makeCarList(Arrays.asList("pobi", "crong", "honux", "teo"));
        int[] fixedNumber = {1, 2, 3, 6};
        for (int i = 0; i < 12; i++) {
            cars.get(i % 4).goForward(fixedNumber[i % 4]);
        }

        List<Car> winners = Arrays.asList(new Car("teo", 3));
        List<Car> rank = gameManager.getWinner(cars);
        for (int i = 0; i < winners.size(); i++) {
            Assertions.assertThat(winners.get(i).equals(rank.get(i))).isEqualTo(true);
        }

    }

    @Test
    public void multiWinnerTest() {
        int[] fixedNumber = {5, 2, 3, 6};
        List<Car> cars = gameManager.makeCarList(Arrays.asList("pobi", "crong", "honux", "teo"));
        for (int i = 0; i < 12; i++) {
            cars.get(i % 4).goForward(fixedNumber[i % 4]);
        }
        List<Car> realWinner = gameManager.getWinner(cars);

        List<Car> expectedWinner = Arrays.asList(new Car("pobi"), new Car("teo"));

        for (int i = 0; i < realWinner.size(); i++) {
            Assertions.assertThat(realWinner.get(i).equals(expectedWinner.get(i))).isEqualTo(true);
        }
    }

}
