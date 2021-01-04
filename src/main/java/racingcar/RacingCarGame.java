package racingcar;

public class RacingCarGame {
    private static final int LIMIT_NAME = 5;

    public String[] splitName(String text) {
        return checkName(text.split(","));
    }

    private String[] checkName(String[] names) {
        for (String name : names) {
            checkOverflow(name);
        }
        return names;
    }

    private void checkOverflow(String name) {
        if (name.length() > LIMIT_NAME) {
            throw new RuntimeException();
        }
    }
}
