package carRace;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingGameUI {
    public static String[] getNamesFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.next();
        return split(input);
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

    private static String[] split(String userInput) {
        return userInput.split(",");
    }
}
