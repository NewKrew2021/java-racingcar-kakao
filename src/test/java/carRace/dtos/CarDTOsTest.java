package carRace.dtos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("CarDTO 클래스")
public class CarDTOsTest {
    CarDTOs dtos = new CarDTOs(
            Arrays.asList(
                    new CarDTO("test1", 6),
                    new CarDTO("test2", 2),
                    new CarDTO("test3", 4),
                    new CarDTO("test4", 5),
                    new CarDTO("test5", 10),
                    new CarDTO("test6", 10)
            )
    );

    @DisplayName("사이즈 체크")
    @Test
    public void sizeTest() {
        assertThat(dtos.size()).isEqualTo(6);
    }

    @DisplayName("보유한 멤버의 이름을 가져오는 기능 테스트")
    @Test
    public void getNameOfTest() {
        assertThat(dtos.getNameOf(3)).isEqualTo("test4");
    }

    @DisplayName("보유한 멤버의 위치정보를 가져오는 기능 테스트")
    @Test
    public void getLocationOfTest() {
        assertThat(dtos.getNameOf(5)).isEqualTo("test6");
    }
}
