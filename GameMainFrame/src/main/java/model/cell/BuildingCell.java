package model.cell;

import enigma.console.TextAttributes;
import model.gamepad.GamePad;

import java.awt.*;

/**
 * User: tcz
 * Date: 13-2-2
 * Time: 下午1:52
 */
public class BuildingCell extends Cell {
    public BuildingCell(char mark) {
        super(mark);
    }

    @Override
    void action() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void print(GamePad gamePad) {
        gamePad.console.setTextAttributes(new TextAttributes(Color.WHITE));
        System.out.print(mark);
    }
}
