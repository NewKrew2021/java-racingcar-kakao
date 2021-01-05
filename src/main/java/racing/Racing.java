package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Racing {

    private List<Car> cars;
    private static Scanner sc = new Scanner(System.in);
    int progressNumber = 0;

    public void setCars(String s) {
        String[] nameArray = s.split(",");
        this.cars = new ArrayList<>();
        for (String name : nameArray) {
            this.cars.add(new Car(name));
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void run() {
        this.startMessagePrint();
        String carNames = sc.next();
        this.setCars(carNames);
        this.tryMessagePrint();
        this.progressNumber = sc.nextInt();
        System.out.println("\n실행 결과");
        this.repeatRacing(progressNumber);
        this.printWinner();
    }

    public List<Integer> repeatRacing(int numbers) {
        while (checkPosition(numbers)) {
            this.race();
            this.racePrint();
        }
        return getPositions();
    }

    private void startMessagePrint() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    private void tryMessagePrint() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public void printWinner() {
        String s = "";
        List<Integer> resultPosition = this.getPositions();
        for (int i = 0; i < resultPosition.size(); i++) {
            s += isWinner(i);
        }
        s = s.substring(0, s.length() - 2);
        s += "가 최종 우승했습니다.";
        System.out.print(s);
    }

    public String isWinner(int index) {
        String s = "";
        if(cars.get(index).getPosition() == this.progressNumber) {
            s += cars.get(index).getName() + ", ";
        }
        return s;
    }

    public void racePrint() {
        for (Car car : this.cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    private List<Integer> getPositions() {
        List<Integer> result = new ArrayList<>();
        for (Car car : this.cars) {
            result.add(car.getPosition());
        }
        return result;
    }

    private boolean checkPosition(int numbers) {
        int maxPosition = 0;
        for (Car car : this.cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition < numbers;
    }

    private void race() {
        List<Integer> randomValues = this.makeRandomValues();
        for (int i = 0; i < this.cars.size(); i++) {
            cars.get(i).move(cars.get(i).goOrStop(randomValues.get(i)));
        }
    }

    private List<Integer> makeRandomValues() {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < this.cars.size(); i++) {
            results.add((int) (Math.random() * 10000 % 10));
        }
        return results;
    }
}
