/*
 * File     : RacingUITest.java
 * Date     : 2021. 01. 05
 */
package racing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.view.RacingInputUI;

/*
 * Class    : RandomGameLogicMainClass
 * Version  : 1.1
 * author   : eli.nabro
 *
 * Random game main class for testing
 */
public class RacingGameMainTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux\n5\n"})
    void runTest(String input) {
        RacingGameMain racingGameMain = new RacingGameMain();
        RacingInputUI.setInputStreamForTest(input);
        racingGameMain.run();
    }

}
