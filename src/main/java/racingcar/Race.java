package racingcar;

import java.util.Scanner;

public class Race {
    static int tryNum = 0;
    static String carNames = "";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        Racingcar newRacingcar = new Racingcar();
        RandomNumber newRandomNum = new RandomNumber();

        inputCarNames(newRacingcar);
        inputTryNum();

        newRandomNum.tryNum(newRacingcar);
    }

    private static void inputCarNames(Racingcar newRacingcar){
        do{
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
            carNames = sc.next();
        }while(carNames.isEmpty() || !newRacingcar.setCarList());
    }

    private static void inputTryNum(){
        while(tryNum < 1){
            System.out.println("시도할 횟수는 몇회인가요?");
            tryNum = sc.nextInt();
        }
        System.out.println("실행 결과");
    }
}
