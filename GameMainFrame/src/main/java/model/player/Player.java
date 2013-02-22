package model.player;

import enigma.console.TextAttributes;
import model.gamepad.GamePad;
import model.toy.Block;
import model.toy.Bomb;
import model.toy.Toy;

import java.awt.*;
import java.util.Random;

/**
 * User: tcz
 * Date: 13-1-15
 * Time: 下午7:13
 */
public class Player {
    private final int id;
    private final String name;
    private final char mark;
    private final Color color;
    private int position;
    public Property property;
    boolean isInHospital;

    public Player(int id, int money) {
        this.id = id;
        switch (id) {
            case 0:
                name = "no name";
                mark = 'N';
                color = Color.WHITE;
                break;
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
            default:
                name = "no name";
                mark = 'N';
                color = Color.WHITE;
                break;
        }
        property = new Property(money, 0, 0, 0, 0);
    }

    public int roll(GamePad gamePad) {
        int rollnum = new Random().nextInt(6) + 1;
        int exPosition = this.position;
        this.position = (position + rollnum) % 69;
        Toy nearestBlock = null;
        for (Toy toy : gamePad.toys) {
            if (toy.getClass() == Block.class && toy.getPosition() > exPosition && toy.getPosition() < this.getPosition()) {
                this.position = toy.getPosition();
                nearestBlock = toy;
            }
        }
        if (nearestBlock != null) {
            gamePad.toys.remove(nearestBlock);
        }
        for (Toy toy : gamePad.toys) {
            if (toy.getClass() == Bomb.class && toy.getPosition() == this.getPosition()) {
                this.sentToHospital(gamePad);
            }
        }
        return rollnum;
    }

    void sentToHospital(GamePad gamePad) {
        System.out.println("Bomb!!! You got hurted by a Bomb, now sent to hospital.... (press any key to continue)");
        this.position = 14;
        this.isInHospital = true;
        gamePad.console.readLine();
    }

    public void printPrompt(GamePad gamePad) {
        gamePad.console.setTextAttributes(new TextAttributes(color));
        System.out.print(name + " 位于 " + position + " >");
        gamePad.console.setTextAttributes(new TextAttributes(Color.white));
    }

    public void printInfo(GamePad gamePad) {
        gamePad.erase();
        System.out.println(name);
        System.out.println(property.toString());
        System.out.println("(press any key to continue)");
        gamePad.console.readLine();
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

    public int getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public char getMark() {
        return mark;
    }

    public Color getColor() {
        return color;
    }

}
