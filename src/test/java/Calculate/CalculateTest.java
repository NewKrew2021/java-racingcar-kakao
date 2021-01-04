package Calculate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateTest {
    private Calculate calculate;
    @BeforeEach
    void setUp() {
         calculate = new Calculate();
    }

    @Test
    public void empty_String(){
        assertEquals(0,calculate.parser(""));
        assertEquals(0,calculate.parser(""));

    }

    @Test
    public void null_String(){
        assertEquals(0,calculate.parser(null));

    }

    @Test
    public void singleNumber() {
        Assertions.assertThat(calculate.parser("1")).isEqualTo(1);
    }

    @Test
    public void twoNumberOneComma(){
        assertEquals( 4, calculate.calculating("1,3"));
        assertEquals( 2, calculate.calculating("1,1"));

    }

    @Test
    public void splitByCommaAndColon() {
        Assertions.assertThat(calculate.calculating("1:3")).isEqualTo(4);
        Assertions.assertThat(calculate.calculating("4:7")).isEqualTo(11);
    }

    @Test
    public void customSeparator(){
        assertEquals(3,calculate.calculating("//;\n1;2"));
        assertEquals(3,calculate.calculating("//-l\n1-l2"));

    }

}
