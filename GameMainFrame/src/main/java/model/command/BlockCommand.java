package model.command;

import model.gamepad.GamePad;
import model.player.Player;
import model.toy.Block;

/**
 * Created with IntelliJ IDEA.
 * User: tcz
 * Date: 13-2-12
 * Time: 上午11:38
 */
public class BlockCommand implements Command {
    private Player player;
    private GamePad gamePad;
    private int position;

    public BlockCommand(Player player, GamePad gamePad, int position) {
        this.player = player;
        this.gamePad = gamePad;
        this.position = position;
    }

    @Override
    public void execute() {
        if (this.player.property.getBlock() > 0) {
            player.property.setBlock(player.property.getBlock() - 1);
            gamePad.toys.add(new Block(position));
        }
    }
}
