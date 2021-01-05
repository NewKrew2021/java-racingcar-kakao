import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printCars(List<Car> cars) {
        String str = cars.stream()
                .map(car -> car.getName() + " : " + getDistanceString(car.getPosition())+"\n")
                .collect(Collectors.joining());
        System.out.println(str);
    }

    private static String getDistanceString(int position) {
        String s = "";
        for (int i = 0; i < position; i++) {
            s += "-";
        }
        return s;
    }

    public static void printWinnerCars(List<Car> winnerCars) {
        String winnerCarNames = winnerCars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winnerCarNames + "가 최종 우승했습니다.");
    }
}
