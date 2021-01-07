package racingcar.view;

import racingcar.domain.Cars;
import racingcar.domain.TryNo;
import racingcar.util.StringUtil;

import java.util.Scanner;

public class InputView {

    private static Scanner sc = new Scanner(System.in);

    public static Cars getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] names = StringUtil.splitComma(sc.nextLine());
        return new Cars(names);
    }

    public static TryNo getTryNo() {
        System.out.println("시도할 횟수는 몇회인가요?");
        int tryNo = sc.nextInt();
        return new TryNo(tryNo);
    }
}
