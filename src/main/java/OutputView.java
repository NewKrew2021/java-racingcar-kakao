import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printCars(List<Car> cars) {
        String formattedCarsStatus = cars.stream()
                .map(car -> String.format("%s : %s\n", car.getName(), getDistanceString(car.getPosition())))
                .collect(Collectors.joining());
        System.out.println(formattedCarsStatus);
    }

    private static String getDistanceString(int position) {
        return Collections.nCopies(position, "-")
                .stream()
                .collect(Collectors.joining());
    }

    public static void printWinnerCars(List<Car> winnerCars) {
        String winnerCarNames = winnerCars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winnerCarNames + "가 최종 우승했습니다.");
    }
}
