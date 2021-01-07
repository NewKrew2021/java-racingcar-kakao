package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarInputViewTest {

    @Test
    @DisplayName("사용자의 입력된 텍스트를 올바르게 파싱하였는지 테스트한다.")
    void parseCarNameTest(){
        String text = "hendo,brody,summer";
        List<String> nameList = CarInputView.parseCarName(text);
        assertAll(() -> assertThat(nameList).hasSize(3),
                () -> assertTrue(nameList.contains("hendo")),
                () -> assertTrue(nameList.contains("brody")),
                () -> assertTrue(nameList.contains("summer")));
    }

}
