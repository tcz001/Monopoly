package model.command;

import model.player.Player;

/**
 * Created with IntelliJ IDEA.
 * User: tcz
 * Date: 13-2-12
 * Time: 上午10:38
 * To change this template use File | Settings | File Templates.
 */
public class RollCommand implements Command{
    private Player player;
    public RollCommand(Player player){
        this.player=player;
    }
    @Override
    public void execute() {
        player.roll();
    }
}
