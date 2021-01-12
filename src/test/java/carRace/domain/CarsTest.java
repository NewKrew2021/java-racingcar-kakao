package carRace.domain;

import carRace.dtos.CarDTO;
import carRace.dtos.CarDTOs;
import org.junit.jupiter.api.BeforeEach;
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
            new String[]{
                    "test1",
                    "test2",
                    "test3",
                    "test4",
                    "test5",
                    "test6"
            }
    );

    @DisplayName("먼저 정해진 strategy로 차들을 움직여 본다.")
    @BeforeEach
    public void movingAllCarsAccordingToManualStrategyBeforeTest() {
        testCars.moveAllCarsAccordingTo(
                new MovingStrategy(){
                    final Queue<Boolean> patterns = new LinkedList<>(Arrays.asList(false, false, false, true, true, true));

                    @Override
                    public boolean movable(){
                        return patterns.poll(); //이렇게 테스트 하는게 괜찮은건지... 궁금합니다.
                    }
                }
        );
    }

    @DisplayName("모든 자동차가 주어진 strategy에 맞게 움직였는지 테스트한다.")
    @Test
    public void moveAllCarsAccordingToTest() {
        CarDTOs realResult = testCars.getCarInformations();
        CarDTOs expectedResult = new CarDTOs(
                Arrays.asList(
                        new CarDTO("test1", 0),
                        new CarDTO("test2", 0),
                        new CarDTO("test3", 0),
                        new CarDTO("test4", 0 + 1),
                        new CarDTO("test5", 0 + 1),
                        new CarDTO("test6", 0 + 1)
                )
        );

        assertThat(realResult).isEqualTo(expectedResult);
    }

    @DisplayName("주어진 자동차들중에서 우승자들의 이름을 구하는 기능 테스트")
    @Test
    public void getWinningCarNamesTest() {
        List<String> realNames = testCars.getWinningCarNames();
        List<String> expectedNames = Arrays.asList("test4", "test5", "test6");
        assertThat(realNames).isEqualTo(expectedNames);
    }
}