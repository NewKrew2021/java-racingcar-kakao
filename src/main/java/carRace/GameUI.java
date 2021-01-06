package carRace;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameUI {
    private static final int MAX_NAME_LENGTH = 5;

    public static CarSet getCarsFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String[] names = split(scanner.nextLine());

        if(isValid(names)){
            return new CarSet(names);
        }

        return retryGetCarsFromUser();
    }

    private static CarSet retryGetCarsFromUser(){
        Scanner scanner = new Scanner(System.in);
        String[] names;

        do {
            System.out.println("이름이 잘못되었습니다. 다시 입력해주세요(이름은 쉼표(,)를 기준으로 구분)");
            names = split(scanner.nextLine());
        }while(!isValid(names));

        return new CarSet(names);
    }

    private static String[] split(String userInput) {
        return userInput.split(",");
    }

    private static boolean isValid(String[] names){
        boolean valid = true;

        for (String name : names) {
            valid &= isValidForEach(name);
        }
        return valid;
    }

    private static boolean isValidForEach(String name){
        return isAlphabetString(name) && isAllowedLength(name);
    }

    private static boolean isAlphabetString(String name) {
        boolean valid = true;
        for (char c : name.toCharArray()) {
            valid &= Character.isAlphabetic(c);
        }
        return valid;
    }

    private static boolean isAllowedLength(String name) {
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

    public static void printAllCars(CarSet carSet) {
        System.out.println(carSet);
    }

    public static void printWinners(List<Car> winners) {
        List<String> winnerNames = winners.stream().map(Car::getName).collect(Collectors.toList());
        System.out.print(String.join(", ", winnerNames));
        System.out.println(" 가 최종 우승했습니다.");
    }
}
