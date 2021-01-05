package carRace;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingGameUI {
    private static final int MAX_NAME_LENGTH = 5;

    public static Cars getCarsFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
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
            throw new RuntimeException(String.format("차 이름은 알파벳이어야 합니다 (문제되는 이름 : \"%s\")", name));
        }
        if(!allowedLength(name)) {
            throw new RuntimeException(String.format("차 이름은 1글자 이상 5글자 이하여야 합니다 (문제되는 이름 : \"%s\")", name));
        }
    }

    private static boolean isAlpha(String name) {
        boolean result = true;
        for (char c : name.toCharArray()) {
            result &= Character.isAlphabetic(c);
        }
        return result;
    }

    private static boolean allowedLength(String name) {
        return 0 < name.length() && name.length() <= MAX_NAME_LENGTH;
    }

    public static int getNumOfRepeatFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    public static void printStartMessage() {
        System.out.println("실행 결과");
    }

    public static void printAllCars(Cars cars) {
        System.out.println(cars);
    }

    public static void printWinners(List<Car> winners) {
        List<String> winnerNames = winners.stream().map(Car::getName).collect(Collectors.toList());
        System.out.print(String.join(", ", winnerNames));
        System.out.println(" 가 최종 우승했습니다.");
    }

}
