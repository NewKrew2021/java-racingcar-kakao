package racingcar.domain.game;

public class Round {
    private final int totalRound;
    private int currentRound;

    public Round(int totalRound){
        this.totalRound=totalRound;
        this.currentRound=0;
    }

    public void playCurrentRound(){
        currentRound++;
    }

    public boolean isRoundFinished(){
        return totalRound==currentRound;
    }
}
