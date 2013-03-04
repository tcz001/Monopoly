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
        this.price = rawPrice / 2;
    }

    public void boughtBy(Player owner) {
        owner.property.setMoney(owner.property.getMoney() - this.rawPrice);
        this.owner = owner;
    }

    @Override
    public void action(Player player) {
        if (this.owner.getId() == 0 && player.property.getMoney() >= rawPrice) {
            System.out.println("是否购买该地产 价格:" + this.rawPrice + " \n(y/n)?");
            if (Enigma.getConsole().readLine().toLowerCase().equals("y")) {
                this.boughtBy(player);
            }
        } else if (this.owner == player) {
            if (player.property.getMoney() > this.rawPrice && this.lever <= 4) {
                System.out.println("是否升级该地产 价格:" + this.rawPrice + " \n(y/n)?");
                if (Enigma.getConsole().readLine().toLowerCase().equals("y")) {
                    this.leverUp();
                }
            }
        } else if (player.isLucky == 0 && owner.isInPrison == 0 && owner.isInPrison == 0) {
            if (player.property.getMoney() > this.rawPrice) {
                this.charge(player);
            }
        } else if (player.isLucky > 0) {
            System.out.println("福神附身，可免过路费");
            Enigma.getConsole().readLine();
        }
    }

    int charge(Player player) {
        player.property.setMoney(player.property.getMoney() - this.price);
        this.owner.property.setMoney(this.owner.property.getMoney() + this.price);
        return this.price;
    }

    void leverUp() {
        this.owner.property.setMoney(this.owner.property.getMoney() - rawPrice);
        this.lever++;
        this.mark = Integer.toString(this.lever).charAt(0);
        this.price *= 2;
    }

    @Override
    public void printOnPad(GamePad gamePad) {
        gamePad.console.setTextAttributes(new TextAttributes(owner.getColor()));
        System.out.print(mark);
    }

    public void sold() {
        this.owner.property.setMoney(this.owner.property.getMoney() + (this.rawPrice * (this.lever + 1)) * 2);
        this.owner = new Player(0, 0);
        this.mark = '0';
        this.lever = 0;
        this.price = rawPrice / 2;
    }

    public int getPrice() {
        return price;
    }

    public Player getOwner() {
        return owner;
    }

    public int getRawPrice() {
        return rawPrice;
    }

    public int getLever() {
        return lever;
    }
}
