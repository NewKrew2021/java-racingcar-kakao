package racingcar;

import java.util.ArrayList;

public class CarMain {
    public static void main(String[] args) {
        ArrayList<String> carNameList = CarView.parseCarName(CarView.writeCarName());
        CarView.validateCarName(carNameList);

        ArrayList<Car> carList = new ArrayList<>();

        for(String carName : carNameList){
            carList.add(new Car(carName, 0));
        }

        CarGame game = new CarGame(carList, CarView.writeRacingRound());

        CarView.printRoundStart();

        while(!game.isFinished()){
            game.playRound();
            CarView.printRoundResult(game);
        }

        CarView.printWinnerCar(game.getWinner());
    }
}
