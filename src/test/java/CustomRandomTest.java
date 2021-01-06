import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CustomRandomTest {
    @Test
    public void isValidRange() {
        int num = CustomRandom.nextInt();
        assertThat(0 <= num && num <= 9).isTrue();
    }
}
