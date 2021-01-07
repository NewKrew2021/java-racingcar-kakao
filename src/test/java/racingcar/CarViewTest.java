package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarViewTest {

    @DisplayName("이름 문자열이 주어졌을 때, 컴마에 따라서 문자열을 똑바로 분할했는지 확인한다.")
    @Test
    void parseCarNameTest() {
        String text = "hendo,brody,summer";
        List<String> nameList = CarView.parseCarName(text);
        assertThat(nameList).contains("hendo").contains("brody").contains("summer");
    }


}
