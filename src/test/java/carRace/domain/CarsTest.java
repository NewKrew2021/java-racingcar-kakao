package carRace.domain;

import carRace.dtos.CarDTO;
import carRace.dtos.CarDTOs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    Cars testCars;

    @BeforeEach
    public void setUp() {
        testCars = new Cars(
                Arrays.asList(
                        new Car("test1", 6),
                        new Car("test2", 2),
                        new Car("test3", 4),
                        new Car("test4", 5),
                        new Car("test5", 10),
                        new Car("test6", 10)
                )
        );
    }

    @Test
    public void moveAllCarsTest() {
        testCars.moveAllCarsAccordingTo(Arrays.asList(1, 2, 3, 4, 5, 6));

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
    public void getWinnersTest() {
        Winners realWinners = testCars.getWinners();
        Winners expectedWinners = new Winners(
                Arrays.asList(
                        new Car("test5", 10),
                        new Car("test6", 10)
                )
        );

        assertThat(realWinners).isEqualTo(expectedWinners);
    }
}