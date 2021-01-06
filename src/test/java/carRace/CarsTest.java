package carRace;

import org.junit.jupiter.api.BeforeEach;

public class CarsTest {

    private final int MOVE = 4;
    private final int NOT_MOVE = 3;

    private Cars testCars;

    @BeforeEach
    public void setUp() {
        String[] testNames = {"car1", "car2", "car3", "car4"};
        testCars = Cars.fromNames(testNames);
    }

//     TODO getWinners와 toString의 결합도 줄이기
//    @Test
//    public void getWinners() {
//        testCars.moveAllCars(moveNumbers1);
//        testCars.moveAllCars(moveNumbers2);
//
//        List<Car> winners = testCars.getWinners();
//
//        String expected = "[car1 : --, car3 : --]";
//        assertThat(winners.toString()).isEqualTo(expected);
//    }
}