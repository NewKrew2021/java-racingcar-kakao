package racingcar.util;

import java.util.Arrays;

public class InputValidChecker {

    public static boolean isValidNames(String input) {
        String[] names = input.split(",");
        return isNameLengthValid(names) && isNotDuplicatedName(names);
    }

    public static boolean isValidRounds(String input) {
        int round = 0;
        try {
            round = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return isRoundPositive(round);
    }

    private static boolean isNameLengthValid(String[] names) {
        return Arrays.stream(names)
                .noneMatch(name -> name.length() > 0 && name.length() > 5);
    }

    private static boolean isNotDuplicatedName(String[] names) {
        return Arrays.stream(names)
                .distinct()
                .count() == names.length;
    }

    private static boolean isRoundPositive(int round) {
        return round > 0;
    }
}
