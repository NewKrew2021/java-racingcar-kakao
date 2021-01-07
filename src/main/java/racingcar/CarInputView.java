package racingcar;

import java.util.*;

public class CarInputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> parseCarName(String text) {
        return new ArrayList<String>(Arrays.asList(text.split(",")));
    }

    public static String writeCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputName = scanner.nextLine();
        if (inputName == null) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다. (null)");
        }
        return inputName;
    }

    public static int writeRacingRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        int roundNumber = 0;
        try {
            roundNumber = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("잘못 입력했습니다. 정수만 입력 가능합니다.");
        }
        return roundNumber;
    }
}
