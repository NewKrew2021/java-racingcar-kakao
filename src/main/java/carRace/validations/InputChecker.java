package carRace.validations;

import carRace.utils.StringUtil;

public class InputChecker {
    private static final int MAX_NAME_LENGTH = 5;

    public static boolean isValid(String[] names) {
        boolean valid = true;

        for (String name : names) {
            valid &= isValidForEach(name);
        }
        return valid;
    }

    private static boolean isValidForEach(String name) {
        return StringUtil.isAlphabetString(name) && isAllowedLength(name);
    }

    private static boolean isAllowedLength(String name) {
        return 0 < name.length() && name.length() <= MAX_NAME_LENGTH;
    }
}
