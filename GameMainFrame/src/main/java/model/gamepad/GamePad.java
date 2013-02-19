package model.gamepad;

import enigma.console.Console;
import enigma.core.Enigma;
import model.command.*;
import model.map.Map;
import model.player.Player;
import model.toy.Toy;

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
    public ArrayList<Toy> toys;
    public Console console = Enigma.getConsole();

    public GamePad(Map map, ArrayList<Player> players) {
        this.map = map;
        this.players = players;
        this.toys = new ArrayList<>();
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
        String commandString;
        flush();
        player.printPrompt(this);
        console.getTextWindow().setCursorPosition(16, 10);
        commandString = console.readLine();
        String s = commandString.toLowerCase();
        if (s.equals("roll")) {
            command = new RollCommand(player, this);

        } else if (s.equals("info")) {
            command = new InfoCommand(player, this);

        } else if (s.matches("bomb [0-9]*")) {
            int position = Integer.parseInt(s.split(" ")[1]);
            command = new BombCommand(player, this, position);

        } else if (s.matches("block [0-9]*")) {
            int position = Integer.parseInt(s.split(" ")[1]);
            command = new BlockCommand(player, this, position);

        } else {
            this.readCommand(player);
            return;
        }
        Invoker invoker = new Invoker(command);
        invoker.action();
        flush();
        if (!commandString.toLowerCase().equals("roll")) this.readCommand(player);
    }
}


