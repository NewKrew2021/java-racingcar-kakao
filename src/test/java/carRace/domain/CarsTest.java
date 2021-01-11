package carRace.domain;

import carRace.dtos.CarDTO;
import carRace.dtos.CarDTOs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("클래스 Cars")
public class CarsTest {
    Cars testCars = new Cars(
            Arrays.asList(
                    new Car("test1", 6),
                    new Car("test2", 2),
                    new Car("test3", 4),
                    new Car("test4", 5),
                    new Car("test5", 10),
                    new Car("test6", 10)
            )
    );

    @Test
    @DisplayName("모든 자동차가 주어진 strategy에 맞게 움직였는지 테스트한다.")
    public void moveAllCarsAccordingToTest() {
        testCars.moveAllCarsAccordingTo(
                new MovingStrategy(){
                    final Queue<Boolean> patterns = new LinkedList<>(Arrays.asList(false, false, false, true, true, true));

                    @Override
                    public boolean movable(){
                        return patterns.poll(); //이렇게 테스트 하는게 괜찮은건지... 궁금합니다.
                    }
                }
        );

        CarDTOs realResult = testCars.getCarInformations();
        CarDTOs expectedResult = new CarDTOs(
                Arrays.asList(
                        new CarDTO("test1", 6),
                        new CarDTO("test2", 2),
                        new CarDTO("test3", 4),
                        new CarDTO("test4", 5 + 1),
                        new CarDTO("test5", 10 + 1),
                        new CarDTO("test6", 10 + 1)
                )
        );

        assertThat(realResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("주어진 자동차들중에서 우승자들의 이름을 구하는 기능 테스트")
    public void getWinningCarNamesTest(){
        List<String> realNames = testCars.getWinningCarNames();
        List<String> expectedNames = Arrays.asList("test5", "test6");
        assertThat(realNames).isEqualTo(expectedNames);
    }
}