package calculator.io;

import calculator.utils.Splitter;
import calculator.utils.SplitterFactory;

import java.util.List;
import java.util.Scanner;

public class Input {
    private static final String SCANNER_NEW_LINE = "\\n";
    private static final String STRING_NEW_LINE = "\n";
    private static final Scanner scanner = new Scanner(System.in);

    public static List<Integer> getCalculatorInput(){
        String input = scanner.next();

        // Scanner \n 입력 != 문자열 "\n"
        input = input.replace(SCANNER_NEW_LINE, STRING_NEW_LINE);
        return splitUserInput(input);
    }

    public static List<Integer> splitUserInput(String userInput){
        List<Integer> list;
        Splitter splitter = SplitterFactory.getSplitter(userInput);
        try {
            list = splitter.split(userInput);
        } catch (NumberFormatException e){
            throw new NumberFormatException(Text.INVALID_INPUT);
        }
        validateInput(list);
        return list;
    }

    private static void validateInput(List<Integer> list) {
        list.forEach(Input::validateInteger);
    }

    private static void validateInteger(Integer v) {
        if (v < 0) {
            throw new RuntimeException(Text.NEGATIVE_VALUE);
        }
    }


}