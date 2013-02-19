package model.toy;

import enigma.console.TextAttributes;
import model.gamepad.GamePad;

import java.awt.*;

/**
 * User: tcz
 * Date: 13-2-19
 * Time: 下午5:50
 */
public abstract class Toy {
    private final int id;
    private final char mark;
    private final Color color;
    private int position;

    public Toy(int id, char mark, Color color, int position) {
        this.id = id;
        this.mark = mark;
        this.color = color;
        this.position = position;
    }

    public void printOnPad(GamePad gamePad) {
        int x = 0, y = 0;
        if (position < 29) {
            x = position + 1;
            y = 0;
        } else if (position >= 29 && position < 35) {
            x = 30;
            y = position - 27;
        } else if (position >= 35 && position < 64) {
            x = 64 - position;
            y = 9;
        } else if (position >= 64) {
            x = 0;
            y = 69 - position;
        }
        gamePad.console.getTextWindow().setCursorPosition(x, y);
        gamePad.console.setTextAttributes(new TextAttributes(color));
        System.out.print(mark);
        gamePad.console.setTextAttributes(new TextAttributes(Color.white));
    }
}
