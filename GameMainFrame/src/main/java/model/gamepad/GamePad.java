package model.gamepad;

import enigma.console.Console;
import enigma.core.Enigma;
import model.command.*;
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
    public Map map;
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
                readCommand(aPlayer);
            }
        }
    }

    public void flush() {
        erase();
        map.printOnPad(this);
    }

    public void erase() {
        console.getTextWindow().setCursorPosition(0, 0);
        for (int i = 0; i < console.getTextWindow().getColumns(); i++) {
            for (int j = 0; j < console.getTextWindow().getRows(); j++) {
                System.out.print(' ');
            }
            System.out.println();
        }
        console.getTextWindow().setCursorPosition(0, 0);
    }

    private void readCommand(Player player) throws IOException {
        Command command = null;
        HashSet<String> commandSet = new HashSet<>();
        commandSet.add("roll");
        commandSet.add("info");
        commandSet.add("block");
        String commandString;
        do {
            flush();
            player.printPrompt(this);
            console.getTextWindow().setCursorPosition(16, 10);
            commandString = console.readLine();
        }
        while (!commandSet.contains(commandString.toLowerCase()));
        switch (commandString.toLowerCase()) {
            case "roll":
                command = new RollCommand(player, this);
                break;
            case "info":
                command = new InfoCommand(player, this);
                break;
            case "block":
                command = new BlockCommand(player, this);
                break;
        }
        Invoker invoker = new Invoker(command);
        invoker.action();
        flush();
        if (!commandString.toLowerCase().equals("roll")) this.readCommand(player);
    }

}


