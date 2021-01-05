package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setInit() {
        cars = new Cars();
    }

    @Test
    void setCarsTest(){
        cars.setCars("pobi,crong,honux");
        assertThat(cars.getCars()).extracting(Car::getName).isSubsetOf("pobi","crong","honux");
    }

    @Test
    @DisplayName("1회 자동차 이동 확인")
    void moveTest(){
        cars.setCars("pobi,crong,honux");
        cars.move();
        assertThat(cars.getCars()).extracting(Car::getLoccation).isSubsetOf(0,1);
    }
//
//    @Test
//    @DisplayName("1대의 자동차 방향 확인")
//    void carDirection() {
//        CarStatus dir = randomNumber.setDirection();
//        assertThat(dir).isInstanceOfAny(CarStatus.class);
//    }

//    @Test
//    @DisplayName("N대의 자동차 전진/멈춤")
//    void carMoveCheck() {
//        Race.carNames = "pobi,crong,honux";
//        cars.setCarList();
//        List<Car> car = cars.setCalLocTest(randomNumber);
//        for (int i = 0; i <car.size() ; i++) {
//            assertThat(car.get(i).getLoc()).isNotNegative();
//        }
//    }




}