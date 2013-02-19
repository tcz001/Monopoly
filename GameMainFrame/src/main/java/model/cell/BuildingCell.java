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
    private int lever;
    private int rawPrice;
    private int price;

    public BuildingCell(int rawPrice) {
        super('0');
        this.owner = new Player(0, 0);
        this.lever = 0;
        this.rawPrice = rawPrice;
        this.price = rawPrice;
    }

    void setOwner(Player owner) {
        owner.property.setMoney(owner.property.getMoney()-this.rawPrice);
        this.owner = owner;
    }

    @Override
    public void action(Player player) {
        if (this.owner.getId() == 0 && player.property.getMoney() >= rawPrice) {
            System.out.println("是否购买该地产 价格:" + this.rawPrice + " \n(y/n)?");
            if (Enigma.getConsole().readLine().toLowerCase().equals("y")) {
                this.setOwner(player);
            }
        } else if (this.owner == player) {
            if (player.property.getMoney() > this.rawPrice && this.lever <= 4) {
                System.out.println("是否升级该地产 价格:" + this.rawPrice + " \n(y/n)?");
                if (Enigma.getConsole().readLine().toLowerCase().equals("y")) {
                    this.leverUp();
                }
            }
        } else {
            if (player.property.getMoney() > this.rawPrice) {
                this.charge(player);
            }
        }
    }

    int charge(Player player) {
        player.property.setMoney(player.property.getMoney() - this.price);
        this.owner.property.setMoney(this.owner.property.getMoney() + this.price);
        return this.price;
    }

    void leverUp() {
        this.lever++;
        this.mark = Integer.toString(this.lever).charAt(0);
        this.price *= 1.5;
    }

    @Override
    public void printOnPad(GamePad gamePad) {
        gamePad.console.setTextAttributes(new TextAttributes(owner.getColor()));
        System.out.print(mark);
    }
}
