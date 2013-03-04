package model.player;

import enigma.console.TextAttributes;
import enigma.core.Enigma;
import model.cell.BuildingCell;
import model.gamepad.GamePad;
import model.tool.Block;
import model.tool.Bomb;
import model.tool.Tool;

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
    public int isInHospital;
    public int isInPrison;
    public int isLucky;

    public Player(int id, int money) {
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
            default:
                name = "default";
                mark = 'N';
                color = Color.WHITE;
                break;
        }
        property = new Property(money, 0, 0, 0, 0);
        isInHospital = 0;
        isInPrison = 0;
        isLucky = 0;
    }

    public int roll(GamePad gamePad) {
        int rollnum = new Random().nextInt(6) + 1;
        int exPosition = this.position;
        this.position = (position + rollnum) % 69;
        Tool nearestBlock = null;
        for (Tool tool : gamePad.tools) {
            if (tool.getClass() == Block.class && tool.getPosition() > exPosition && tool.getPosition() < this.getPosition()) {
                this.position = tool.getPosition();
                nearestBlock = tool;
            }
        }
        if (nearestBlock != null) {
            gamePad.tools.remove(nearestBlock);
        }
        for (Tool tool : gamePad.tools) {
            if (tool.getClass() == Bomb.class && tool.getPosition() == this.getPosition()) {
                this.sentToHospital();
            }
        }
        return rollnum;
    }

    void sentToHospital() {
        System.out.println("Bomb!!! You got hurt by a Bomb, now sent to Hospital.... (press any key to continue)");
        this.position = 14;
        this.isInHospital = 3;
        Enigma.getConsole().readLine();
    }

    public void sentToPrison() {
        System.out.println("Sorry!!! You are now sent to Prison.... (press any key to continue)");
        this.position = 49;
        this.isInPrison = 2;
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

    public void sell(GamePad gamePad, int position) {
        if (gamePad.map.cells.get(position).getClass() == BuildingCell.class) {
            BuildingCell buildingCell = (BuildingCell) gamePad.map.cells.get(position);
            if (buildingCell.getOwner() == this) buildingCell.sold();
            else {
                System.out.println("Wrong position ! is it a BuildingCell ? ,and be sure thar you own it!");
                System.out.println("(press any key to continue)");
                gamePad.console.readLine();
            }
        }
    }
}
