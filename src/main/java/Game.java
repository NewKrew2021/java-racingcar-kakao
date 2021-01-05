public class Game {
    public void start(){
        String names = IOUtils.getNames();
        int trial = IOUtils.getTrial();

        Cars cars = new Cars(names);
        doTrial(cars, trial);
        printResult(cars);
    }

    private void doTrial(Cars cars, int trial){
        for(int i = 0; i < trial; i++){
            System.out.println("실행결과");
            cars.moveAll();
            cars.printPositions();
            System.out.println("");
        }
    }

    private void printResult(Cars cars){
        cars.printHeads();
        System.out.println("가 최종 우승했습니다.");
    }
}