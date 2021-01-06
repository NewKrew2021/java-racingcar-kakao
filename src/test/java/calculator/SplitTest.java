package calculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.Assertions.*;

public class SplitTest {
    @Test
    public void splitTest(){
        Input input = new Input("1,2:3");
        List<Integer> splitted = input.split();
        assertThat(splitted).asList().containsAll(Arrays.asList(1, 2, 3));
    }

    @Test
    public void emptySplitTest(){
        Input input = new Input("");
        List<Integer> splitted = input.split();
        assertThat(splitted).asList().containsAll(Arrays.asList(0));
    }

    @Test
    public void customSplitTest() {
        Input input = new Input("//;\n1;2;3");
        List<Integer> splitted = input.split();
        assertThat(splitted).asList().containsAll(Arrays.asList(1, 2, 3));
    }

    @Test
    public void addTest1(){
        Input userInput = new Input("//'\n1'2'3'4'5");
        assertThat(userInput.add()).isEqualTo(15);
    }

    @Test
    public void addTest2() {
        Input input = new Input("1,2,3");
        assertThat(input.add()).isEqualTo(6);
    }

    @Test
    public void runtimeExceptionTest() {
        Input input = new Input("-1:2:3");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(input::split).withMessageMatching("음수가 포함되었습니다.");
    }

    @Test
    public void runtimeExceptionCustomSplitTest() {
        Input input = new Input("//;\n-1;2;3");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(input::split).withMessageMatching("음수가 포함되었습니다.");
    }
}
