package model.command;

import model.gamepad.GamePad;
import model.player.Player;
import model.tool.Bomb;

/**
 * User: tcz
 * Date: 13-2-19
 * Time: 下午7:30
 */
public class BombCommand implements Command {
    private Player player;
    private GamePad gamePad;
    private int position;

    public BombCommand(Player player, GamePad gamePad, int position) {
        this.player = player;
        this.gamePad = gamePad;
        this.position = position;
    }

    @Override
    public void execute() {
        if (this.player.property.getBomb() > 0 && position <= 10 && position >= -10) {
            player.property.setBomb(player.property.getBomb() - 1);
            gamePad.tools.add(new Bomb(position+player.getPosition()));
        }
    }
}
