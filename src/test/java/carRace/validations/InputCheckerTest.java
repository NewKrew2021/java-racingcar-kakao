package carRace.validations;

import org.junit.jupiter.api.Test;

public class InputCheckerTest {

    @Test
    public void isValidTest() {
        String[] testStrings = new String[]{
                "hello", "wolrd", "How", "Are", "you"
        };
        InputChecker.isValid(testStrings);
    }
}
