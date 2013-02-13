package model.map;

import model.cell.*;
import model.gamepad.GamePad;
import model.player.Player;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * User: tcz
 * Date: 13-1-14
 * Time: 下午8:26
 */
public class Map {
    ArrayList<Cell> cells;
    final int width = 29, height = 8;

    public Map(ArrayList<Street> streets) {
        cells = new ArrayList<>();
        cells.add(new StartCell());
        cells.addAll(streets.get(0).cells);
        cells.add(new HospitalCell());
        cells.addAll(streets.get(1).cells);
        cells.add(new ToyCell());
        cells.addAll(streets.get(2).cells);
        cells.add(new GiftCell());
        cells.addAll(streets.get(3).cells);
        cells.add(new PoisonCell());
        cells.addAll(streets.get(4).cells);
        cells.add(new MagicCell());
        cells.add(new MineCell(20));
        cells.add(new MineCell(80));
        cells.add(new MineCell(100));
        cells.add(new MineCell(40));
        cells.add(new MineCell(80));
        cells.add(new MineCell(60));
    }

    public void printOnPad(GamePad gamePad) {
        gamePad.console.getTextWindow().setCursorPosition(0, 0);
        for (int i = 0; i < height + 3; i++) {
            for (int j = 0; j < width + 2; j++) {
                System.out.print(' ');
            }
            System.out.println();
        }
        gamePad.console.getTextWindow().setCursorPosition(1, 1);
        for (int i = 0; i < width; i++)
            this.cells.get(i).printOnPad(gamePad);
        for (int i = 0; i < height - 2; i++) {
            gamePad.console.getTextWindow().setCursorPosition(1, i + 2);
            char[] cells = new char[width - 2];
            Arrays.fill(cells, ' ');
            this.cells.get(width * 2 + height * 2 - 5 - i).printOnPad(gamePad);
            System.out.print(new String(cells));
            this.cells.get(width + i).printOnPad(gamePad);
        }
        gamePad.console.getTextWindow().setCursorPosition(1, height);
        for (int i = 0; i < width; i++)
            cells.get(width * 2 + height - 3 - i).printOnPad(gamePad);
        for (Player aPlayer : gamePad.players) {
            aPlayer.printOnPad(gamePad);
        }
        gamePad.console.getTextWindow().setCursorPosition(0, height + 2);
    }

    public void playerActionOnCell(Player player) {
        this.cells.get(player.getPosition()).action(player);
    }
}
