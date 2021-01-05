package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    /* 자동차 이름 설정 */
    public void setCars(String carNames){
        String[] parsingCarNames = splitCarNames(carNames);
        checkCarNames(parsingCarNames);
        addCarName(parsingCarNames);
    }

    private String[] splitCarNames(String carNames){
        return carNames.replace(" ", "").split(",");
    }

    private void addCarName(String[] carNames) {
        for(String carName: carNames){
            cars.add(new Car(carName));
        }
    }

    private void checkCarNames(String[] carNames){
        for (String carName : carNames) {
            lengthCheck(carName);
        }

    }

    private void lengthCheck(String carName) {
        if (carName.length() > 5){
            throw new RuntimeException("길이를 5이하로 설정해주세요");
        }
    }


    /* getter */
    public List<Car> getCars(){
        return cars;
    }

    /* 난수 생성후 해당 난수 조건에 따라 이 */
    public void move(){
        for(Car car:cars){
            car.move(checkMove());
        }
        Output.printNewLine();
    }

    private int checkMove(){
        if (setRandomNumber() >= 4){
            return 1;
        }
        return 0;

    }

    private int setRandomNumber(){
        return (int)(Math.random()*10);
    }

    /* 우승자 확인 */
    public String checkWinner(){
        int winnerLocation = getWinnerLocation();
        return getWinnerNames(winnerLocation);
    }

    private String getWinnerNames(int winnerLocation) {
        String winner = "";
        for(Car car:cars){
            if (car.getLoccation() == winnerLocation){
                winner += car.getName() + " ";
            }
        }
        return winner;
    }

    private int getWinnerLocation(){
        return cars.stream().mapToInt(car -> car.getLoccation()).max().orElse(0);
    }

}