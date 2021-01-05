package calculator;

import org.assertj.core.api.NotThrownAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {

    @Test
    public void splitAndSum_input_zero(){
        String testInput = "";
        assertThat(Calculator.splitAndSum(testInput)).isEqualTo(0);
    }

    @Test
    public void splitAndSum_input_null(){
        String testInput = null;
        assertThat(Calculator.splitAndSum(testInput)).isEqualTo(0);
    }

    @Test
    public void splitAndSum_input_OneInteger(){
        String testInput = "2";
        assertThat(Calculator.splitAndSum(testInput)).isEqualTo(2);
    }

    @Test
    public void splitAndSum_input_twoInteger() {
        String testInput = "1,2";
        assertThat(Calculator.splitAndSum(testInput)).isEqualTo(3);
    }

    @Test
    public void splitAndSum_input_moreInteger() {
        String testInput = "1,2,3,4,5";
        assertThat(Calculator.splitAndSum(testInput)).isEqualTo(15);
    }

    @Test
    public void splitAndSum_input_twoDelimiter() {
        String testInput = "1,2:3";
        assertThat(Calculator.splitAndSum(testInput)).isEqualTo(6);
    }

    @Test
    public void splitAndSum_input_customDelimiter() {
        String testInput = "//;\n1;2;3";
        assertThat(Calculator.splitAndSum(testInput)).isEqualTo(6);
    }

    @Test
    public void splitAndSum_input_negative() {
        String testInput = "-1,2,3";

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    Calculator.splitAndSum(testInput);
                }).withMessageMatching("minus error");
    }

    @Test
    public void splitAndSum_input_notInteger(){
        String testInput = "//;\n1;2;a;3";

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    Calculator.splitAndSum(testInput);
                }).withMessageMatching("not integer error");
    }
}
