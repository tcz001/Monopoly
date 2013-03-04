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
public class GiftCell extends Cell {
    public GiftCell(){
        super('G');
    }
    @Override
    public void action(Player player) {
        System.out.println("1. 奖励 2000 元");
        System.out.println("2. 奖励 200 point");
        System.out.println("3. 福神 附身");
        System.out.println("输入1,2,3，或任意其他键回车放弃");
        String choice = Enigma.getConsole().readLine();
        switch (choice) {
            case "1":
                player.property.setMoney(player.property.getMoney()+2000);
                break;
            case "2":
                player.property.setPoint(player.property.getPoint()+200);
                break;
            case "3":
                player.isLucky = 5;
        }
    }

    @Override
    public void printOnPad(GamePad gamePad) {
        gamePad.console.setTextAttributes(new TextAttributes(Color.LIGHT_GRAY));
        System.out.print(mark);
    }
}

