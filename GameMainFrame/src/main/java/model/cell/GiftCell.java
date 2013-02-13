package model.cell;

import enigma.console.TextAttributes;
import model.gamepad.GamePad;
import model.player.Player;

import java.awt.*;
/**
 * User: tcz
 * Date: 13-2-2
 * Time: 上午11:06
 */
public class GiftCell extends Cell {
    public GiftCell(){
        super('G');
    }
    @Override
    public void action(Player player) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void printOnPad(GamePad gamePad) {
        gamePad.console.setTextAttributes(new TextAttributes(Color.LIGHT_GRAY));
        System.out.print(mark);
    }
}

