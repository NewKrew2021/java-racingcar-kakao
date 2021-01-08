package racingcar.utils;

import java.util.Arrays;

public class InputValidChecker {

    private InputValidChecker() {
        throw new IllegalStateException("Utility Class");
    }

    public static boolean isValidNames(String input) {
        String[] names = input.split(",");
        return isNotConsecutiveComma(input) && isNotDuplicatedName(names);
    }

    public static boolean isValidRounds(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    private static boolean isNotConsecutiveComma(String input) {
        return !input.contains(",,");
    }

    private static boolean isNotDuplicatedName(String[] names) {
        return Arrays.stream(names)
                .distinct().count() == names.length;
    }
}
