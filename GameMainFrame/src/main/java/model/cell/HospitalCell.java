package model.cell;

import enigma.console.TextAttributes;
import model.gamepad.GamePad;

import java.awt.*;

/**
 * User: tcz
 * Date: 13-2-2
 * Time: 上午11:19
 */
public class HospitalCell extends Cell {

    public HospitalCell() {
        super('H');
    }

    @Override
    void action() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void print(GamePad gamePad) {
        gamePad.console.setTextAttributes(new TextAttributes(Color.RED));
        System.out.print(mark);
    }
}
