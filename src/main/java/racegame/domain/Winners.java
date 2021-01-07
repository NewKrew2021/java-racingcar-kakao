package racegame.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = Collections.unmodifiableList(winners);
    }

    @Override
    public String toString() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

}
