package model.cell;

import enigma.console.TextAttributes;
import enigma.core.Enigma;
import model.gamepad.GamePad;
import model.player.Player;

/**
 * User: tcz
 * Date: 13-2-2
 * Time: 下午1:52
 */
public class BuildingCell extends Cell {
    private Player owner;

    public BuildingCell() {
        super('0');
        owner = new Player(0, 0);
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    @Override
    public void action(Player player) {
        if (this.owner.getId() == 0) {
            System.out.println("是否购买该地产(y/n)?");
            if (Enigma.getConsole().readLine().toLowerCase().equals("y")) {
                this.setOwner(player);
            }
        }
    }

    @Override
    public void printOnPad(GamePad gamePad) {
        gamePad.console.setTextAttributes(new TextAttributes(owner.getColor()));
        System.out.print(mark);
    }
}
