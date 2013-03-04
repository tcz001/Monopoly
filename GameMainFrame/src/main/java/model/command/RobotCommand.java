package model.command;

import model.gamepad.GamePad;
import model.player.Player;
import model.tool.Robot;

/**
 * User: tcz
 * Date: 13-2-19
 * Time: 下午7:30
 */
public class RobotCommand implements Command {
    private Player player;
    private GamePad gamePad;

    public RobotCommand(Player player, GamePad gamePad) {
        this.player = player;
        this.gamePad = gamePad;
    }

    @Override
    public void execute() {
        if (this.player.property.getRobot() > 0) {
            player.property.setRobot(player.property.getRobot() - 1);
            Robot.action(player.getPosition(),gamePad);
        }
    }
}

