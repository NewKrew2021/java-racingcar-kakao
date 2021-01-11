package carRace.validations;

import carRace.utils.StringUtil;

import java.util.Arrays;

public class InputChecker {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;

    public static boolean isValid(String[] names) {
        if(isEmptyNames(names)){
            return false;
        }

        return Arrays.stream(names).allMatch(InputChecker::isValidForEach);
    }

    private static boolean isEmptyNames(String[] names){
        return names == null || 0 == names.length;
    }

    private static boolean isValidForEach(String name) {
        return StringUtil.isAlphabetString(name) && isAllowedLength(name);
    }

    private static boolean isAllowedLength(String name) {
        return MIN_NAME_LENGTH <= name.length() && name.length() <= MAX_NAME_LENGTH;
    }
}
