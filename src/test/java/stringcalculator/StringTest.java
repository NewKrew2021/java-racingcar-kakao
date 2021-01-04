package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class StringTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void nullTest() {
        String s = null;
        Assertions.assertThat(stringCalculator.calculate(s)).isEqualTo(0);
    }

    @Test
    void emptyTest() {
        String s = "";
        Assertions.assertThat(stringCalculator.calculate(s)).isEqualTo(0);
    }

    @Test
    void singleNumberTest() {
        String s = "6";
        Assertions.assertThat(stringCalculator.calculate(s)).isEqualTo(6);
    }

    @Test
    void multiNumberTest() {
        String s = "1,2:6";
        Assertions.assertThat(stringCalculator.calculate(s)).isEqualTo(9);
    }

    @Test
    void multiNumberTestWithCustomDelimiter() {
        String s = "//;\n1;2:3";
        Assertions.assertThat(stringCalculator.calculate(s)).isEqualTo(6);
    }

    @Test
    void notNumberTest() {
        String s = "!;2:3";
        Assertions.assertThatExceptionOfType(RuntimeException.class).
                isThrownBy(() -> {
                    Assertions.assertThat(stringCalculator.calculate(s));
                });
    }

    @Test
    void negativeNumberTest() {
        String s = "-1";
        Assertions.assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            Assertions.assertThat(stringCalculator.calculate(s));
        });
    }

    @Test
    void noNumberTest() {
        String s = ",";
        Assertions.assertThat(stringCalculator.calculate(s)).isEqualTo(0);
    }
}
