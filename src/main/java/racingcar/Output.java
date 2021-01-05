package racingcar;

public class Output {

    public static void printInputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
    }

    public static void printInputRound() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public static void printResult() {
        System.out.println("실행 결과");
    }

    public static void printRoundResult(String name, int num) {
        System.out.println(name + " : " + "-".repeat(num));
    }

    public static void printNewLine() {
        System.out.print("\n");
    }
}
