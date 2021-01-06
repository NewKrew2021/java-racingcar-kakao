package racingcar.utils;

public class StringUtils {
    private static final int NAME_MAX_LENGTH = 5;

    public static boolean isNameOverMaxLength(String name) {
        return name.length() > NAME_MAX_LENGTH;
    }

    public static boolean isBlank(String name) {
        return name == null || name.isEmpty();
    }
}
