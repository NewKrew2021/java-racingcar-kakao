package racingcar.utils;

import java.util.Arrays;

public class InputValidChecker {

    private InputValidChecker() {
        throw new IllegalStateException("Utility Class");
    }

    public static boolean isValidNames(String input) {
        String[] names = input.split(",");
        return isNotConsecutiveComma(input) && isNameLengthValid(names) && isNotDuplicatedName(names);
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

    private static boolean isNameLengthValid(String[] names) {
        return Arrays.stream(names)
                .noneMatch(name -> name.length() > 5 || name.length() < 1);
    }

    private static boolean isNotDuplicatedName(String[] names) {
        return Arrays.stream(names)
                .distinct().count() == names.length;
    }
}
