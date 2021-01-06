package Calculator;

import Calculator.exception.NegativeNumberInputException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    String[] result;

    @Test
    void splitAndSum_complexDelimeter() {
        assertThat(Calculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void splitAndSum_emptyString() {
        assertThat(Calculator.splitAndSum("")).isEqualTo(0);
    }

    @Test
    void splitAndSum_customDelimeter() {
        assertThat(Calculator.splitAndSum("//!\\n1!2!3")).isEqualTo(6);
    }

    @Test
    void splitAndSum_customDelimeters() {
        assertThat(Calculator.splitAndSum("//!@\\n1!2@3")).isEqualTo(6);
    }

    @Test
    void splitAndSum_nullPointerException() {
        assertThatThrownBy(() -> {
            Calculator.splitAndSum(null);
        }).isInstanceOf(NullPointerException.class);
    }

    @Test
    void splitAndSum_negativeNumberInputException() {
        assertThatThrownBy(() -> {
            Calculator.splitAndSum("-1:2:3");
        }).isInstanceOf(NegativeNumberInputException.class);
    }

    @Test
    void splitAndSum_numberFormatException() {
        assertThatThrownBy(() -> {
            Calculator.splitAndSum("zx:2:3");
        }).isInstanceOf(NumberFormatException.class);
    }

    @Test
    void splitAndSum_runtimeException() {
        assertThatThrownBy(() -> {
            Calculator.splitAndSum("zx:2:3");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void splitTest_comma() {
        result = splitString("1,2,3", ",");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void splitTest_colon() {
        result = splitString("1:2:3", ":");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void splitTest_complex() {
        result = splitString("1:2,3", ",|:");
        assertThat(result).containsExactly("1", "2", "3");
    }


    String[] splitString(String src, String regex) {
        return src.split(regex);
    }

}
