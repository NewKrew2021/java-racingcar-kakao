package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class CarViewTest {

    @Test
    void parseCarNameTest(){
        String text = "hendo,brody,summer";
        ArrayList<String> nameList = CarView.parseCarName(text);
        assertThat(nameList).contains("hendo").contains("brody").contains("summer");
    }


}
