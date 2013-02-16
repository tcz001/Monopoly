package model.command;

import model.gamepad.GamePad;
import model.map.Map;
import model.player.Player;

/**
 * Created with IntelliJ IDEA.
 * User: tcz
 * Date: 13-2-12
 * Time: 上午10:38
 */
public class RollCommand implements Command {
    private Player player;
    private GamePad gamePad;

    public RollCommand(Player player, GamePad gamePad) {
        this.player = player;
        this.gamePad = gamePad;
    }

    @Override
    public void execute() {
        player.roll();
        gamePad.flush();
        player.printPrompt(gamePad);
        System.out.println();
        gamePad.map.playerActionOnCell(player);
    }
}
