package racingcar.view;

public class CarsStatusView {

    public static void printCarName(String name) {
        System.out.printf("%-4s : ", name);
    }

    public static void printStatusBar(int number) {
        for (int i = 0; i < number; i++) {
            System.out.print("-");
        }
        newLine();
    }

    public static void newLine() {
        System.out.println();
    }
}
