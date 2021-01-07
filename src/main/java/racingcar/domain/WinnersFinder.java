package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WinnersFinder {

    public List<String> findWinners(List<CarInfo> carInfos) {
        List<String> winnerNames = new ArrayList<>();
        int maxPosition = carInfos.stream().
                max(Comparator.comparing(CarInfo::getPosition)).get().getPosition();
        List<CarInfo> winnerCarInfos = carInfos.stream().
                filter(carInfo -> carInfo.getPosition() == maxPosition).collect(Collectors.toList());

        for (CarInfo winnerCarInfo : winnerCarInfos) {
            winnerNames.add(winnerCarInfo.getName());
        }
        return winnerNames;
    }
}
