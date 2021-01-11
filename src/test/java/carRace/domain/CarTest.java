package carRace.domain;

import carRace.dtos.CarDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Car 클래스 테스트")
public class CarTest {

    @Test
    @DisplayName("생성자를 통해 이름이 잘 전달되었는지 확인한다.")
    public void getNameTest() {
        Car car = new Car("holly");
        assertThat(car.getName()).isEqualTo("holly");
    }

    @Test
    @DisplayName("DTO 가 잘 생성되었는지 확인한다.")
    public void getDTOTest() {
        Car car = new Car("jolly");
        car.judgeAndGo(() -> true);
        assertThat(car.getDTO()).
                isEqualTo( new CarDTO("jolly", 1) );
    }

    @Test
    @DisplayName("움직이지 않아야 할때, 움직이지 않았는지 테스트한다.")
    public void judgeAndGo_Test1() {
        Car car = new Car("mother");
        car.judgeAndGo(() -> false);
        assertThat(car.getLocation()).isEqualTo(0);
    }

    @Test
    @DisplayName("움직여야 할때, 움직였는지 테스트한다.")
    public void judgeAndGo_Test2() {
        Car car = new Car("mother");
        car.judgeAndGo(() -> true);
        assertThat(car.getLocation()).isEqualTo(1);
    }

    @Test
    @DisplayName("Car 클래스에 저장된 location정보가 정확히 얻어와 지는지 확인한다.")
    public void getLocationTest() {
        Car car = new Car("mother");
        for(int i = 0; i < 1000; i++){
            car.judgeAndGo(() -> true);
        }
        assertThat(car.getLocation()).isEqualTo(1000);
    }
}