package calculate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateTest {
    private Calculate calculate;

    @BeforeEach
    void setUp() {
        calculate = new Calculate();
    }

    @Test
    public void testEmpty_String() {
        assertEquals(0, calculate.parser(""));
        assertEquals(0, calculate.parser(""));

    }

    @Test
    public void testNull_String() {
        assertEquals(0, calculate.parser(null));

    }

    @Test
    public void testSingleNumber() {
        Assertions.assertThat(calculate.parser("1")).isEqualTo(1);
    }

    @Test
    public void testTwoNumberOneComma() {
        assertEquals(4, calculate.calculating("1,3"));
        assertEquals(2, calculate.calculating("1,1"));

    }

    @Test
    public void testSplitByCommaAndColon() {
        Assertions.assertThat(calculate.calculating("1:3")).isEqualTo(4);
        Assertions.assertThat(calculate.calculating("4:7")).isEqualTo(11);
    }

    @Test
    public void testCustomSeparator() {
        assertEquals(3, calculate.calculating("//;\n1;2"));
        assertEquals(3, calculate.calculating("//-l\n1-l2"));

    }

    @Test
    public void testMinusValueException() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> calculate.calculating("//;;\n1;;2;;-3"))
                .withMessageMatching("Negative value");
    }

    @Test
    public void testNumberFormatException() {
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> calculate.calculating("//;;\n1;;2;;ㄱ"));
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> calculate.calculating("//;;\n1;; 2;;3"));
    }


}

