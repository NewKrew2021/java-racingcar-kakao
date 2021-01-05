import java.util.List;
import java.util.Scanner;

public class RacingCarGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String carString = scanner.next();

        List<String> carNames = StringUtil.parseString(carString);

        CarManager carManager = new CarManager();

        for (String carName : carNames) {
            carManager.pushCar(new Car(carName));
        }

        for (Car car : carManager.getCars()) {
            System.out.println(car.getName());
        }
    }
}
