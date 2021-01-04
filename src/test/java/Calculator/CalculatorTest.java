package Calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    String[] result;


    @Test
    void splitAndSum_complexDelimeter() {
        assertThat(Calculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void splitAndSum_nullString() {
        assertThat(Calculator.splitAndSum(null)).isEqualTo(0);
    }

    @Test
    void splitAndSum_emptyString() {
        assertThat(Calculator.splitAndSum("")).isEqualTo(0);
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
