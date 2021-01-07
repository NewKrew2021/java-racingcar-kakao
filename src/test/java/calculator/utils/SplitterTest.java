package calculator.utils;

import calculator.io.Input;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.Assertions.*;

public class SplitterTest {
    @Test
    public void splitTest(){
        List<Integer> splitted = Input.splitUserInput("1,2:3");
        assertThat(splitted).asList().isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    public void negativeSplitTest(){
        List<Integer> splitted = Input.splitUserInput("1,2:3");
        assertThat(splitted).asList().isNotEqualTo(Arrays.asList(1, 2, 3, 4));
    }

    @Test
    public void emptySplitTest(){
        List<Integer> splitted = Input.splitUserInput("");
        assertThat(splitted).asList().isEqualTo(Arrays.asList(0));
    }

    @Test
    public void emptyCustomSplitTest(){
        List<Integer> splitted = Input.splitUserInput("//;\\n");
        assertThat(splitted).asList().isEqualTo(Arrays.asList(0));
    }

    @Test
    public void customSplitTest() {
        List<Integer> splitted = Input.splitUserInput("//;\n1;2;3");
        assertThat(splitted).asList().isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    public void runtimeExceptionTest() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(()->Input.splitUserInput("-1:2:3"));
    }

    @Test
    public void runtimeExceptionCustomSplitTest() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(()->Input.splitUserInput("//;\n-1;2;3"));
    }
}
