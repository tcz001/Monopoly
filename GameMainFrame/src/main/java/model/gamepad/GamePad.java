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
                flush();
                console.getTextWindow().setCursorPosition(0, 0);
                map.printOnPad(this);
                aPlayer.printPrompt(this);
                readCommand(aPlayer);
            }
        }
    }

    private void flush() {
        console.getTextWindow().setCursorPosition(0, 0);
        for (int i = 0; i < console.getTextWindow().getColumns(); i++) {
            for (int j = 0; j < console.getTextWindow().getRows(); j++) {
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    private void readCommand(Player player) throws IOException {
        Command command = null;
        HashSet<String> commandSet = new HashSet<>();
        commandSet.add("roll");
        commandSet.add("block");
        String commandString;
        do {
            console.getTextWindow().setCursorPosition(16, console.getTextWindow().getCursorY() - 1);
            commandString = console.readLine();
        }
        while (!commandSet.contains(commandString.toLowerCase()));
        switch (commandString.toLowerCase()) {
            case "roll":
                command = new RollCommand(player,map);

                break;
            case "block":
                command = new BlockCommand(player,map);

                break;
        }
        Invoker invoker = new Invoker(command);
        invoker.action();
    }

}


