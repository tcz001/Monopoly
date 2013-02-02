import enigma.console.Console;
import enigma.console.TextAttributes;
import enigma.core.Enigma;

import java.io.*;
import java.util.ArrayList;

/**
 * User: tcz
 * Date: 13-1-15
 * Time: 下午5:11
 */
public class GamePad {
    Map map;
    ArrayList<Player> players;
    Console console = Enigma.getConsole();

    GamePad(Map map, ArrayList<Player> players) {
        this.map = map;
        this.players = players;
    }

    public void print() throws IOException {
        while (true) {
            for (Player aPlayer : players) {
                console.getTextWindow().setCursorPosition(0,0);
                map.print(this);
                print(aPlayer);
                readCommand();
            }
        }
    }

    private void print(Player player) throws IOException {
        console.setTextAttributes(new TextAttributes(player.color));
        System.out.println(player.name + " >");
    }

    private void readCommand() throws IOException {
        console.readLine();
    }

}


