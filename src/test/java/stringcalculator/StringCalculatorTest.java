package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringCalculatorTest {

    @Test
    void nullTest() {
        String data = null;
        int result = StringCalculator.calculate(data);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void blankTest() {
        String data = "";
        int result = StringCalculator.calculate(data);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void singleNumberTest() {
        String data = "3";
        int result = StringCalculator.calculate(data);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void twoNumberAddTest() {
        String data = "3,1";
        int result = StringCalculator.calculate(data);
        assertThat(result).isEqualTo(4);
    }

    @Test
    void threeNumberAddTest() {
        String data = "1,2:3";
        int result = StringCalculator.calculate(data);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void customSeparatorTest() {
        String data = "//;\n1;2;3";
        int result = StringCalculator.calculate(data);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void minusNumberTest() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(()->{
            String data = "-1,2,3";
            StringCalculator.calculate(data);
        });
    }
}