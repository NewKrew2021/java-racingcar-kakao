package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @Test
    void isBlank() {
        assertThat(Calculator.splitAndSum("")).isEqualTo(0);
        assertThat(Calculator.splitAndSum(null)).isEqualTo(0);
    }

    @Test
    void convertNumber() {
        assertThat(Calculator.splitAndSum("12")).isEqualTo(12);
        assertThat(Calculator.splitAndSum("569")).isEqualTo(569);
    }

    @Test
    void sum() {
        assertThat(Calculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void tokenSum() {
        assertThat(Calculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void customTokenSum() {
        assertThat(Calculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void negativeSum() {
        assertThrows(RuntimeException.class, () -> Calculator.splitAndSum("-1,2,3"));
    }
}
