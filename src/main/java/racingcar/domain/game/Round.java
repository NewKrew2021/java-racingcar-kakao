package racingcar.domain.game;

import java.util.Objects;

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

    public boolean isFinished(){
        return totalRound==currentRound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return totalRound == round.totalRound && currentRound == round.currentRound;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalRound, currentRound);
    }
}
