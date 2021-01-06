package Calculator;

import Calculator.exception.NegativeNumberInputException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Calculator {

    String[] splitString(String src, String regex) {
        return src.split(regex);
    }

    static int splitAndSum(String src) throws RuntimeException {
        return isBlank(src) ? 0 : sum(toInts(split(src)));
    }

    private static boolean isBlank(String src){
        return src.isEmpty();
    }

    private static String[] split(String src) {
        return isContainsCustom(src) ? getAfterDelimeterString(src).split(getCustomDelimeter(src.substring(2, src.indexOf("\\n")))) : src.split(",|:");
    }

    private static String getCustomDelimeter(String src){
        if (src.length() == 1) {
            return src;
        }

        StringBuilder delimeterBuilder = new StringBuilder();

        for (int i = 0; i < src.length() - 1; i++) {
            delimeterBuilder.append(src.charAt(i) + "|");
        }

        delimeterBuilder.append(src.charAt(src.length()-1));
        return delimeterBuilder.toString();
    }

    private static String getAfterDelimeterString(String src){
        return src.substring(src.indexOf("\\n") + 2);
    }

    private static int[] toInts(String[] inputs) throws NegativeNumberInputException {
        int[] numbers = new int[inputs.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(inputs[i]);
            isNegativeNumber(numbers[i]);
        }

        return numbers;
    }

    private static void isNegativeNumber(int number) throws NegativeNumberInputException {
        if(number < 0){
            throw new NegativeNumberInputException();
        }
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }

        return sum;
    }

    public static boolean isContainsCustom(String input) {
        return input.charAt(0) == '/';
    }



    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("문자열을 입력해주세요 : ");
            System.out.println(splitAndSum(bufferedReader.readLine()));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
