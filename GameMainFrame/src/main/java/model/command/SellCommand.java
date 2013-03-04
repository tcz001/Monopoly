package model.command;

import model.gamepad.GamePad;
import model.player.Player;

/**
 * Created with IntelliJ IDEA.
 * User: tcz
 * Date: 13-2-16
 * Time: 下午10:06
 */
public class SellCommand implements Command {
    private Player player;
    private GamePad gamePad;
    private int position;

    public SellCommand(Player player, GamePad gamePad,int position) {
        this.player = player;
        this.gamePad = gamePad;
        this.position = position;
    }

    @Override
    public void execute() {
        player.sell(gamePad,position);
    }
}
