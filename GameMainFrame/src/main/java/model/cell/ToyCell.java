package model.cell;

import enigma.console.TextAttributes;
import enigma.core.Enigma;
import model.gamepad.GamePad;
import model.player.Player;
import model.toy.Block;
import model.toy.Bomb;
import model.toy.Robot;
import model.toy.Toy;

import java.awt.*;


/**
 * User: tcz
 * Date: 13-2-2
 * Time: 上午11:43
 */
public class ToyCell extends Cell {
    public ToyCell() {
        super('T');
    }

    @Override
    public void action(Player player) {
        System.out.println("1.Bomb    价格:"+new Bomb().getPrice()+" point");
        System.out.println("2.Robot   价格:"+new Robot().getPrice()+" point");
        System.out.println("3.Block   价格:"+new Block().getPrice()+" point");
        System.out.println("输入1,2,3，或任意其他键回车放弃");
        String choice = Enigma.getConsole().readLine();
        switch (choice) {
            case "1":
                charge(new Block(), player);
                break;
            case "2":
                charge(new Robot(), player);
                break;
            case "3":
                charge(new Bomb(), player);
        }
    }

    public void charge(Toy toy, Player player) {
        if ((player.property.getPoint() - toy.getPrice() > 0)) {
            if (toy.getClass() == Bomb.class) {
                player.property.setPoint(player.property.getPoint() - toy.getPrice());
                player.property.setBomb(player.property.getBomb() + 1);
            } else if (toy.getClass() == Robot.class) {
                player.property.setPoint(player.property.getPoint() - toy.getPrice());
                player.property.setRobot(player.property.getRobot() + 1);
            } else if (toy.getClass() == Block.class) {
                player.property.setPoint(player.property.getPoint() - toy.getPrice());
                player.property.setBlock(player.property.getBlock() + 1);
            }
        }
    }

    @Override
    public void printOnPad(GamePad gamePad) {
        gamePad.console.setTextAttributes(new TextAttributes(Color.LIGHT_GRAY));
        System.out.print(mark);
    }
}
