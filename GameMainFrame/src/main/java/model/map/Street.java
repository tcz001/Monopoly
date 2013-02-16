package model.map;

import model.cell.Cell;
import model.cell.BuildingCell;
import model.gamepad.GamePad;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * User: tcz
 * Date: 13-1-14
 * Time: 下午9:26
 */
public class Street {
    public ArrayList<Cell> cells;


    public Street(String cellString,int rawPrice) {
        this.cells = new ArrayList<>();
        if (cellString.length() == 13 || cellString.length() == 6)
            for (char ignored : cellString.toCharArray()) {
                this.cells.add(new BuildingCell(rawPrice));
            }
    }

    public Street(char ch, int i,int rawPrice) {
        this.cells = new ArrayList<>();
        if (i == 13 || i == 6) {
            char[] cells = new char[i];
            Arrays.fill(cells, ch);
            for (char ignored : cells) {
                this.cells.add(new BuildingCell(rawPrice));
            }
        }
    }
}
