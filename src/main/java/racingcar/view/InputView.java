package racingcar.view;

import com.sun.org.apache.bcel.internal.generic.ATHROW;
import racingcar.domain.Cars;
import racingcar.util.StringUtil;

import java.util.Scanner;

public class InputView {

    private static Scanner sc = new Scanner(System.in);

    public static Cars getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] names = StringUtil.splitComma(sc.nextLine());
        return new Cars(names);
    }

    public static int getTryNo() throws Exception {
        System.out.println("시도할 회수는 몇회인가요?");
        int tryNo = sc.nextInt();
        if (tryNo <= 0) {
            throw new IllegalArgumentException("시도 회수는 1이상이어야 합니다.");
        }
        return tryNo;
    }
}
