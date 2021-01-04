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

}
