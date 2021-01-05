package RacingCar;

import java.util.Arrays;

public class InputValidChecker {

    public static boolean isValidInput(String input) {
        String[] names = splitNames(input);
        return isNameLengthValid(names) && isNotDuplicatedName(names);
    }

    private static String[] splitNames(String input) {
        return input.split(",");
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
