package racingcar.view;

import racingcar.domain.*;

import java.util.List;

public class OutputView {

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printCars(List<CarInfo> carsInfo) {
        StringBuilder sb = new StringBuilder();
        for (CarInfo c : carsInfo) {
            sb.append(c.getName()).append(" : ");
            addLocation(sb, c);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void addLocation(StringBuilder sb, CarInfo carInfo) {
        for (int i = 0; i < carInfo.getLocation(); i++) {
            sb.append("-");
        }
    }

    public static void printWinners(Winner winner) {
        StringBuilder sb = new StringBuilder();
        sb.append(winner.toString()).append("가 최종 우승했습니다.");
        System.out.println(sb.toString());
    }
}