package model.command;

import model.gamepad.GamePad;
import model.player.Player;

/**
 * Created with IntelliJ IDEA.
 * User: tcz
 * Date: 13-2-16
 * Time: 下午10:06
 */
public class QueryCommand implements Command {
    private Player player;
    private GamePad gamePad;

    public QueryCommand(Player player, GamePad gamePad) {
        this.player = player;
        this.gamePad = gamePad;
    }

    @Override
    public void execute() {
        player.printInfo(gamePad);
    }
}
