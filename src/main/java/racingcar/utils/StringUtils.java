package racingcar.utils;

public class StringUtils {
    public static boolean isNameOverMaxLength(String name, int maxLength) {
        return name.length() > maxLength;
    }

    public static boolean isBlank(String name) {
        return name == null || name.isEmpty();
    }
}
