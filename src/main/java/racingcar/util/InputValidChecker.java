package racingcar.util;

import java.util.Arrays;

public class InputValidChecker {

    public static boolean isValidNames(String input) {
        String[] names = input.split(",");
        return isNameLengthValid(names) && isNotDuplicatedName(names);
    }

    public static boolean isValidRounds(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }

    private static boolean isNameLengthValid(String[] names) {
        return Arrays.stream(names)
                .noneMatch(name -> name.length() > 5);
    }

    private static boolean isNotDuplicatedName(String[] names) {
        return Arrays.stream(names)
                .distinct().count() == names.length;
    }
}
