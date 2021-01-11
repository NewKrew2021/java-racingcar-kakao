package carRace.validations;

import carRace.utils.StringUtil;

import java.util.Arrays;

public class InputChecker {
    private static final int MAX_NAME_LENGTH = 5;

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
        return 0 < name.length() && name.length() <= MAX_NAME_LENGTH;
    }
}
