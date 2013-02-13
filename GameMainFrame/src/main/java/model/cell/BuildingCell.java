package model.cell;

import enigma.console.TextAttributes;
import model.gamepad.GamePad;
import model.player.Player;

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
    public void action(Player player) {
        System.out.print("是否购买该地产");
    }

    @Override
    public void printOnPad(GamePad gamePad) {
        gamePad.console.setTextAttributes(new TextAttributes(Color.WHITE));
        System.out.print(mark);
    }
}
