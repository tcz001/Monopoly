package model.gamepad;

import enigma.console.Console;
import enigma.core.Enigma;
import model.command.BlockCommand;
import model.command.Command;
import model.command.Invoker;
import model.command.RollCommand;
import model.map.Map;
import model.player.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * User: tcz
 * Date: 13-1-15
 * Time: 下午5:11
 */
public class GamePad {
    Map map;
    public ArrayList<Player> players;
    public Console console = Enigma.getConsole();

    public GamePad(Map map, ArrayList<Player> players) {
        this.map = map;
        this.players = players;
    }

    public void print() throws IOException {
        while (true) {
            for (Player aPlayer : players) {
                console.getTextWindow().setCursorPosition(0, 0);
                map.print(this);
                aPlayer.print(this);
                command(aPlayer);
            }
        }
    }

    private void command(Player player) throws IOException {
        Command command = null;
        HashSet<String> commandSet = new HashSet<>();
        commandSet.add("Roll");
        commandSet.add("roll");
        commandSet.add("Block");
        commandSet.add("block");
        String commandString;
        do {
            console.getTextWindow().setCursorPosition(8, console.getTextWindow().getCursorY() - 1);
            commandString = console.readLine();
        }
        while (!commandSet.contains(commandString));
        switch (commandString) {
            case "Roll":
                command = new RollCommand(player);

                break;
            case "Block":
                command = new BlockCommand(player);

                break;
        }
        Invoker invoker = new Invoker(command);
        invoker.action();
    }

}


