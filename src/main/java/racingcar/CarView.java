package racingcar;

import java.util.*;

public class CarView {

    public static List<String> parseCarName(String text){
        return new ArrayList<String>(Arrays.asList(text.split(",")));
    }

    public static void validateCarName(List<String> nameList) throws IllegalStateException {
        for (String name : nameList) {
            lengthValidationTest(name);
        }
    }

    private static void lengthValidationTest(String name){
        if(name.length() > 5) {
            throw new IllegalStateException();
        }
    }

    public static String writeCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int writeRacingRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void printRoundStart() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printRoundResult(CarGame game) {
        for(Car car : game.getCarList()){
            System.out.println(car.getName() + " : " + String.join("", Collections.nCopies(car.getPosition(), "-")));
        }
        System.out.println();
    }

    public static void printWinnerCar(List<String> winners) {
        System.out.println(String.join(",", winners) + "가 최종 우승했습니다.");
    }

}
