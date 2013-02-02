import enigma.console.TextAttributes;

import java.awt.*;

/**
 * User: tcz
 * Date: 13-2-2
 * Time: 上午11:19
 */
public class HospitalCell extends Cell {

    HospitalCell() {
        super('H');
    }

    @Override
    void action() {

    }

    @Override
    void print(GamePad gamePad) {
        gamePad.console.setTextAttributes(new TextAttributes(Color.RED));
        System.out.print(mark);
    }
}
