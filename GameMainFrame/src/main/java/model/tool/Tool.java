package model.tool;

import enigma.console.TextAttributes;
import model.gamepad.GamePad;

import java.awt.*;

/**
 * User: tcz
 * Date: 13-2-19
 * Time: 下午5:50
 */
public abstract class Tool {
    private final char mark;
    private final Color color;
    private final int price;
    private int position;

    public Tool(char mark, Color color, int price, int position) {
        this.mark = mark;
        this.color = color;
        this.price = price;
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

    public int getPosition() {
        return position;
    }

    public int getPrice() {
        return price;
    }
}
