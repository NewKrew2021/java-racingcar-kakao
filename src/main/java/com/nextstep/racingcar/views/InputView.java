package com.nextstep.racingcar.views;

import com.nextstep.racingcar.utils.InputCheck;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private final Scanner SC = new Scanner(System.in);

    public String[] scanCarNames() {
        String[] names = carNames();

        for (String name : names) {
            checkNameIsValid(name);
        }
        return names;
    }

    public int scanRepeatCount() {
        int repeatCount = repeatCount();
        checkCountIsValid(repeatCount);
        return repeatCount;
    }

    private void checkNameIsValid(String name) {
        if (!InputCheck.isValidName(name)) {
            String message = String.format("Name: %s is invalid.", name);
            throw new RuntimeException(message);
        }
    }

    private String[] carNames() {
        String namesInput;

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉽표(,)를 기준으로 구분).");
        namesInput = SC.next();
        return namesInput.split(",");
    }

    private int repeatCount() {
        int count;

        System.out.println("시도할 회수는 몇회인가요?");
        try {
            count = SC.nextInt();
        } catch (InputMismatchException e) {
            throw new RuntimeException(e);
        }

        return count;
    }

    private void checkCountIsValid(int repeatCount) {
        if (isNegative(repeatCount)) {
            throw new RuntimeException("Repeat count should be positive");
        }
    }

    private boolean isNegative(int value) {
        return value < 0;
    }
}
