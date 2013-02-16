package model.command;

/**
 * Created with IntelliJ IDEA.
 * User: tcz
 * Date: 13-2-12
 * Time: 上午11:00
 */
public class Invoker {
    private Command command = null;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action() {
        command.execute();
    }
}
