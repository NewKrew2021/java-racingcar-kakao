package racingcar.util;

public class StringUtil {
    private StringUtil(){
        throw new AssertionError();
    }
    public static boolean isNullOrEmpty(String str){
        return str == null || str.isEmpty();
    }

    public static boolean isOverMaxLength(String name, int maxNameLength) {
        return name.length() > maxNameLength;
    }

    public static String[] splitComma(String input){
        return input.split(",");
    }
}
