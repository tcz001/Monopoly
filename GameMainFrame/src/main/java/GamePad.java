import enigma.console.Console;
import enigma.console.TextAttributes;
import enigma.core.Enigma;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * User: tcz
 * Date: 13-1-15
 * Time: 下午5:11
 */
public class GamePad {
    Map map;
    ArrayList<Player> players;

    GamePad(Map map, ArrayList<Player> players) {
        this.map = map;
        this.players = players;
    }

    public void print() throws IOException {
        while (true) {
            for (Player aPlayer : players) {
                System.out.flush();
                print(map);
                print(aPlayer);
                readCommand();
            }
        }
    }

    private void print(Player player) throws IOException {
        console.setTextAttributes(new TextAttributes(player.color));
        System.out.println(player.name + "\t");
    }

    private void print(Map map) {
        console.setTextAttributes(new TextAttributes(Color.WHITE));
        System.out.print("S");
        System.out.print(map.streets.get(0).cellString);
        System.out.print("H");
        System.out.print(map.streets.get(1).cellString);
        System.out.print("T\n");
        for (int i = 0; i < map.height - 2; i++) {
            char[] cells = new char[map.width - 2];
            Arrays.fill(cells, ' ');
            System.out.println("$" + new String(cells) + map.streets.get(2).cellString.charAt(i));
        }
        System.out.print("M");
        System.out.print(map.streets.get(3).cellString);
        System.out.print("P");
        System.out.print(map.streets.get(4).cellString);
        System.out.print("G\n");
    }

    private void readCommand() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
    }

    private static Console console = Enigma.getConsole("Monopoly");
}


