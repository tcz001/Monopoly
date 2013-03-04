package model.cell;

import enigma.console.TextAttributes;
import enigma.core.Enigma;
import model.gamepad.GamePad;
import model.player.Player;

import java.awt.*;

/**
 * User: tcz
 * Date: 13-2-2
 * Time: 上午11:06
 */
public class PrisonCell extends Cell {
    public PrisonCell() {
        super('P');
    }

    @Override
    public void action(Player player) {
        player.sentToPrison();
        Enigma.getConsole().readLine();
    }

    @Override
    public void printOnPad(GamePad gamePad) {
        gamePad.console.setTextAttributes(new TextAttributes(Color.LIGHT_GRAY));
        System.out.print(mark);
    }
}

