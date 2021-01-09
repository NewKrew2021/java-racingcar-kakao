package carRace.utils;

public class StringUtil {

    public static boolean isAlphabetString(String name) {
        boolean valid = true;
        for (char c : name.toCharArray()) {
            valid &= Character.isAlphabetic(c);
        }
        return valid;
    }
}
