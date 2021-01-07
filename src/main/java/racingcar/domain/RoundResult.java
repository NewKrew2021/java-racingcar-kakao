package racingcar.domain;

import java.util.Map;

public class RoundResult {
    private Map<String, Integer> result;

    public RoundResult(Map<String, Integer> result) {
        this.result = result;
    }

    public Map<String, Integer> getResult() {
        return this.result;
    }

}
