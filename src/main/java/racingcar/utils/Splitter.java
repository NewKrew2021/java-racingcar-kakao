package racingcar.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Splitter {

    private static final String SPLIT_DELIMITER = ",";

    public static List<String> splitNames(String string) {
        string = string.replace(" ", "");
        return new ArrayList<>(Arrays.asList(string.split(SPLIT_DELIMITER)));
    }
}
