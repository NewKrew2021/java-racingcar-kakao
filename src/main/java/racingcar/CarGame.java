package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarGame {
    public static ArrayList<String> parseCarName(String text){
        return new ArrayList<String>(Arrays.asList(text.split(",")));
    }
}
