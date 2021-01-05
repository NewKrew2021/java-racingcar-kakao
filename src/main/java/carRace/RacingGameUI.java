package carRace;

import java.util.Arrays;
import java.util.Scanner;

public class RacingGameUI {
    private static final int MAX_NAME_LENGTH = 5;

    public static Cars getCarsFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.next();
        return validationAndConvert(split(input));
    }

    private static String[] split(String userInput) {
        return userInput.split(",");
    }

    private static Cars validationAndConvert(String[] names) {
        validationForAll(names);
        return new Cars(names);
    }

    private static void validationForAll(String[] names){
        for (String name : names) {
            validationForEach(name);
        }
    }
    private static void validationForEach(String name){
        if(!isAlpha(name)){
            throw new RuntimeException(String.format("차 이름은 알파벳이어야 합니다 - %s", name));
        }
        if(!allowedLength(name)) {
            throw new RuntimeException(String.format("차 이름은 다섯글자 이하여야 합니다 - %s", name));
        }
    }

    private static boolean allowedLength(String name) {
        return name.length() <= MAX_NAME_LENGTH;
    }

    private static boolean isAlpha(String name) {
        boolean result = true;
        for (char c : name.toCharArray()) {
            result &= Character.isAlphabetic(c);
        }
        return result;
    }
}
