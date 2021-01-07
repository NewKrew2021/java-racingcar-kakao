package racingcar;

import java.util.*;

public class CarInputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> parseCarName(String text){
        return new ArrayList<String>(Arrays.asList(text.split(",")));
    }

    public static String writeCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public static int writeRacingRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

}
