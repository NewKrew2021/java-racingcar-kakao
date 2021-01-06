package racingcar.view;

public class InputPrinter {

    private InputPrinter() {
        throw new IllegalStateException("Utility Class");
    }

    public static void inputNamePrint() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void inputRoundPrint() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
    }

    public static void illegalNamePrint() {
        System.out.println("잘못된 입력입니다.");
    }

    public static void illegalRoundPrint() {
        System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
    }
}
