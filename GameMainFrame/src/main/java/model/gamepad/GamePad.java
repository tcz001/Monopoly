package model.gamepad;

import enigma.console.Console;
import enigma.core.Enigma;
import model.map.Map;
import model.player.Player;

import java.io.IOException;
import java.util.ArrayList;

/**
 * User: tcz
 * Date: 13-1-15
 * Time: 下午5:11
 */
public class GamePad {
    Map map;
    ArrayList<Player> players;
    public Console console = Enigma.getConsole();

    public GamePad(Map map, ArrayList<Player> players) {
        this.map = map;
        this.players = players;
    }

    public void print() throws IOException {
        while (true) {
            for (Player aPlayer : players) {
                console.getTextWindow().setCursorPosition(0,0);
                map.print(this);
                aPlayer.print(this);
                readCommand();
            }
        }
    }

    private void readCommand() throws IOException {
        console.readLine();
    }

}


