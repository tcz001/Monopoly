package model.cell;

import model.gamepad.GamePad;
import model.player.Player;

/**
 * User: tcz
 * Date: 13-1-29
 * Time: 下午9:27
 */
public abstract class Cell {
    char mark;

    Cell(char mark) {
        this.mark = mark;
    }

    public abstract void action(Player player);

    public abstract void printOnPad(GamePad gamePad);
}
