package racingcar;

import java.util.List;
import java.util.Scanner;

public class Ui {
    private Scanner sc;
    private Racing racing;

    public void start() {
        sc = new Scanner(System.in);
        racing = new Racing();
        setCarList();
        int time = setTime();
        race(time);
    }

    public void setCarList() {
        boolean complete = false;

        while (!complete) {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            racing.setCars(sc.next());
            complete = !racing.isTooLong();
        }
    }

    public int setTime() {
        System.out.println("시도할 회수는 몇회인가요?");
        return sc.nextInt();
    }

    public void race(int time) {
        System.out.println("\n실행 결과");

        while (time-- > 0) {
            racing.moveAll();
            printDistance();
        }

        printWinner();
    }

    public void printDistance() {
        for (int i = 0; i < racing.getCars().size(); i++) {
            Car car = racing.getCars().get(i);
            System.out.println(car.getName() + " : " + new String(new char[car.getDistance()]).replace("\0", "-"));
        }

        System.out.println();
    }

    public void printWinner() {
        List<Car> winners = racing.getWinners();
        String s = "";

        for (Car car : winners)
            s += car.getName() + ", ";

        s = s.substring(0, s.length() - 2);
        System.out.println(s + "가 최종 우승했습니다.");
    }
}
