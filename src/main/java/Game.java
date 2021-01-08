import model.Cars;
import view.IOUtils;

import java.io.IOException;

public class Game {
    public void start() throws IOException {
        String names = IOUtils.getNames();
        int trial = IOUtils.getTrial();

        Cars cars = new Cars(names);
        doTrial(cars, trial);
        printResult(cars);
    }

    private void doTrial(Cars cars, int trial) {
        for (int i = 0; i < trial; i++) {
            System.out.println("실행결과");
            cars.moveAll();
            printCurrentStates(cars);
            System.out.println();
        }
    }

    private void printCurrentStates(Cars cars){
        IOUtils.printNameAndPositions(cars);
    }

    private void printResult(Cars cars) {
        IOUtils.printHeads(cars.getHeads());
    }
}