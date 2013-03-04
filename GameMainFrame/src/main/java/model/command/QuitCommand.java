package model.command;

/**
 * User: tcz
 * Date: 13-3-4
 * Time: 下午4:53
 */
public class QuitCommand implements Command {
    public QuitCommand() {
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
