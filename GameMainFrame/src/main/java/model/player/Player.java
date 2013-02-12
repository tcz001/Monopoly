package model.player;

import enigma.console.TextAttributes;
import model.gamepad.GamePad;

import java.awt.*;
import java.io.IOException;
import java.util.Random;

/**
 * User: tcz
 * Date: 13-1-15
 * Time: 下午7:13
 */
public class Player {
    public int id;
    public String name;
    public char mark;
    public Color color;
    int property;
    int point;
    int bomb;
    int block;
    int robot;
    int position;

    public Player(int id, int property) {
        this.id = id;
        switch (id) {
            case 1:
                name = "钱夫人";
                mark = 'Q';
                color = Color.BLUE;
                break;
            case 2:
                name = "阿土伯";
                mark = 'A';
                color = Color.ORANGE;
                break;
            case 3:
                name = "孙小美";
                mark = 'S';
                color = Color.RED;
                break;
            case 4:
                name = "金贝贝";
                mark = 'J';
                color = Color.YELLOW;
                break;
        }
        this.property = property;
        this.point = 0;
        this.bomb = 0;
        this.block = 0;
        this.robot = 0;
    }

    public int roll() {
        int rollnum = new Random().nextInt(20) + 1;
        this.position = (position + rollnum) % 69;
        return rollnum;
    }

    public void print(GamePad gamePad) throws IOException {
        gamePad.console.setTextAttributes(new TextAttributes(color));
        System.out.println(name + " >");
        gamePad.console.setTextAttributes(new TextAttributes(Color.white));
    }

    public void printOnPad(GamePad gamePad) {
        int x = 0, y = 0;
        if (position < 29) {
            x = position+1;
            y = 0;
        } else if (position >= 29 && position < 35) {
            x = 30;
            y = position - 27;
        } else if (position >= 35 && position < 64) {
            x = 64 -position;
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
