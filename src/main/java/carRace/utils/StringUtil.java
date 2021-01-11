package carRace.utils;

public class StringUtil {

    public static boolean isAlphabetString(String name) {
        return isNotEmptyString(name)
                && name.chars().allMatch(Character::isAlphabetic);
    }

    private static boolean isNotEmptyString(String string){
        return (string != null) && (string.isEmpty() == false);
    }
}
