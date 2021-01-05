package calculator.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitterImpl implements Splitter {
    private static final String SPLIT_REGEX = "[,:]";

    public List<Integer> split(String userInput) throws NumberFormatException{
        if(userInput.isEmpty()){
            return Arrays.asList(0);
        }
        return Arrays.stream(userInput.split(SPLIT_REGEX))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
