import enigma.console.TextAttributes;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * User: tcz
 * Date: 13-1-14
 * Time: 下午9:26
 */
public class Street {
    ArrayList<Cell> cells;


    Street(String cells) {
        this.cells = new ArrayList<Cell>();
        if (cells.length() == 13 || cells.length() == 6)
            for (char cell : cells.toCharArray()) {
                this.cells.add(new BuildingCell(cell));
            }
    }

    Street(char ch, int i) {
        this.cells = new ArrayList<Cell>();
        if (i == 13 || i == 6) {
            char[] cells = new char[i];
            Arrays.fill(cells, ch);
            for (char cell : cells){
                this.cells.add(new BuildingCell(cell));
            }
        }
    }

    void print(GamePad gamePad) {
        for (Cell cell : cells) cell.print(gamePad);
    }
}
