package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printResultMessage(){
        System.out.println("실행 결과");
    }

    public static void printCars(Cars cars){
        StringBuilder sb = new StringBuilder();
        List<Car> carsList = cars.getCars();
        for (Car car : carsList) {
            sb.append(car.getName()).append(" : ");
            addLocation(sb, car);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void addLocation(StringBuilder sb, Car car) {
        for(int i = 0; i<car.getLocation(); i++){
            sb.append("-");
        }
    }

    public static void printWinners(List<Car> cars){
        StringBuilder sb = new StringBuilder();
        sb.append(cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(",")));
        sb.append("가 최종 우승했습니다.");
        System.out.println(sb.toString());
    }
}