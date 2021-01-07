package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarInputViewTest {

    @Test
    @DisplayName("사용자의 입력된 텍스트를 올바르게 파싱하였는지 테스트한다.")
    void parseCarNameTest(){
        String text = "hendo,brody,summer";
        List<String> nameList = CarInputView.parseCarName(text);
        assertThat(nameList).contains("hendo").contains("brody").contains("summer");
    }

}
