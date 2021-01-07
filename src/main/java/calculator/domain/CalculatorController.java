package calculator.domain;

import calculator.io.Input;
import calculator.io.Output;

public class CalculatorController {
    public static void addIO() {
        Output.askInput();
        Output.printResult(Calculator.add(Input.getCalculatorInput()));
    }
}
