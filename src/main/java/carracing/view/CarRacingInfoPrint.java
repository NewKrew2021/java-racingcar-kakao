package carracing.view;

import java.util.List;

public class CarRacingInfoPrint {

    private static final String CAR_LIST_INPUT_PHRASE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String RACE_COUNT_PHRASE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_PHRASE = "실행 결과";
    private static final String WINNER_PHRASE = "가 최종 우승했습니다.";
    private static final String WINNER_COMMA = ", ";


    public static void printCarListInputPhrase(){
        System.out.println(CAR_LIST_INPUT_PHRASE);
    }

    public static void printRaceCountPhrase(){
        System.out.println(RACE_COUNT_PHRASE);
    }

    public static void printResultPhrase(){
        System.out.println(RESULT_PHRASE);
    }

    public static void printBlankLine(){
        System.out.println();
    }

    public static void printWinners(List<String> winnerList){
        StringBuilder winnerBuilder = new StringBuilder();

        for (int i = 0; i < winnerList.size()-1; i++) {
            winnerBuilder.append(winnerList.get(i)+WINNER_COMMA);
        }
        winnerBuilder.append(winnerList.get(winnerList.size()-1));

        winnerBuilder.append(WINNER_PHRASE);

        System.out.println(winnerBuilder.toString());
    }
}
