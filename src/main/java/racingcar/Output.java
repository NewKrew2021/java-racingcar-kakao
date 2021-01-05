package racingcar;

import java.util.List;

public class Output {
    static void askCarsName(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    static void askGameTime(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    static void printSimulationResult(List<Car> cars){
        System.out.println("실행 결과");
        for(Car car: cars){
            System.out.print(car.getName() + " : ");
            printLocation(car.getLocation());
            System.out.println();
        }
        System.out.println();
    }

    static void printLocation(int location){
        for (int i = 0; i <= location; ++i) {
            System.out.print('-');
        }
    }

    static void printWinner(List<String> winners){
        String joinedWinners = String.join(", ", winners);
        System.out.println(joinedWinners + "가 최종 우승했습니다.");
    }
}
