package model.map;

import model.cell.HospitalCell;
import model.cell.MineCell;
import model.cell.StartCell;
import model.cell.ToyCell;
import model.gamepad.GamePad;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * User: tcz
 * Date: 13-1-14
 * Time: 下午8:26
 */
public class Map {
    ArrayList<Street> streets;
    final int width=29,height=8;
    public Map(ArrayList<Street> streets){
        this.streets = streets;
    }

    public void print(GamePad gamePad) {
        new StartCell().print(gamePad);
        streets.get(0).print(gamePad);
        new HospitalCell().print(gamePad);
        streets.get(1).print(gamePad);
        new ToyCell().print(gamePad);
        System.out.print("\n");
        for (int i = 0; i < height - 2; i++) {
            char[] cells = new char[width - 2];
            Arrays.fill(cells, ' ');
            new MineCell().print(gamePad);
            System.out.print(new String(cells));
            streets.get(2).cells.get(i).print(gamePad);
            System.out.print("\n");
        }
        System.out.print("M");
        streets.get(3).print(gamePad);
        System.out.print("P");
        streets.get(4).print(gamePad);
        System.out.print("G\n");
    }
}
