package racinggame;

import domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
    public static InputManager inputManager;
    public static UserInputValidator nameInputValidator;
    public static UserInputValidator countInputValidator;
    static {
        inputManager = new InputManager();
        countInputValidator = new UserInputValidator() {
            @Override
            public void validate(String str) throws Exception{
                if(str == null)
                    throw new Exception();
                int num = Integer.parseInt(str);
                if(num <= 0)
                    throw new Exception();
            }
        };
        nameInputValidator = new UserInputValidator() {
            @Override
            public void validate(String stringFromUser) throws Exception{
                String namesArray[] = stringFromUser.split(",");
                for (int i = 0; i < namesArray.length; i++) {
                    new Car(namesArray[i]);
                }
            }
        };
    }
    public void play(){
        Cars cars = new Cars(getCars());
        int tryCount = getCount();
        printRacingGame(cars, tryCount);
        printHeads(cars);
    }
    public List<Car> getCars(){
        String[] names = inputManager.getFromUser(
                "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).",
                nameInputValidator
        ).split(",");

        List<Car> carlist = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            carlist.add(new Car(names[i]));
        }
        return carlist;
    }
    public int getCount(){
        return Integer.parseInt(inputManager.getFromUser("시도할 회수는 몇회인가요?", countInputValidator));
    }
    public void printRacingGame(Cars cars, int tryCount){
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            cars.moveAll(new RandomBasedMoveStrategy());
            cars.printAll();
            System.out.println();
        }
    }
    public void printHeads(Cars cars){
        List<Car> heads = cars.getHeads();
        String headsStr = "";
        for (int i=0; i < heads.size()-1; i++) {
            headsStr += heads.get(i).getName() + ", ";
        }
        headsStr += heads.get(heads.size()-1);
        System.out.println(headsStr + "가 최종 우승했습니다");
    }
}
