package model.cell;

import enigma.console.TextAttributes;
import enigma.core.Enigma;
import model.gamepad.GamePad;
import model.player.Player;
import model.toy.Bomb;
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
        System.out.println("1.Bomb    价格:100 point");
        System.out.println("2.Block   价格:100 point");
        System.out.println("3.Robot   价格:100 point");
        if (Enigma.getConsole().readLine().equals("1")) {
            charge(new Bomb(),player);
        }
    }

    public void charge(Toy toy, Player player) {
        if (toy.getClass() == Bomb.class)
            player.property.setBomb(player.property.getBomb() + 1);
    }

    @Override
    public void printOnPad(GamePad gamePad) {
        gamePad.console.setTextAttributes(new TextAttributes(Color.LIGHT_GRAY));
        System.out.print(mark);
    }
}
