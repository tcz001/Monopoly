package model.cell;

import enigma.console.TextAttributes;
import model.gamepad.GamePad;
import model.player.Player;

import java.awt.*;

/**
 * User: tcz
 * Date: 13-2-2
 * Time: 下午2:14
 */
public class MineCell extends Cell {
    int point;
    public MineCell(int point) {
        super('$');
        this.point = point;
    }

    @Override
    public void action(Player player) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void printOnPad(GamePad gamePad) {
        gamePad.console.setTextAttributes(new TextAttributes(Color.ORANGE));
        System.out.print(mark);
    }
}
