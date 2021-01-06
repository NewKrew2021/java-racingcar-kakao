package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Winners {
    private final List<Car> winners;

    public Winners() {
        winners = new ArrayList<>();
    }

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    protected void addWinner(int mx, Car car) {
        if (car.isWinner(mx)) {
            this.winners.add(car);
        }
    }

    @Override
    public String toString() {
        StringBuilder winnerString = new StringBuilder();
        for (Car winner : winners) {
            winnerString.append(winner.getName()).append(",");
        }
        return winnerString.substring(0, winnerString.length() - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winners winners1 = (Winners) o;
        return Objects.equals(winners, winners1.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }
}
