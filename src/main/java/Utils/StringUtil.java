package Utils;

import java.util.Arrays;
import java.util.List;

public class StringUtil {
    public static List<String> parseString(String nameString) {
        return Arrays.asList(nameString.split(","));
    }
}
