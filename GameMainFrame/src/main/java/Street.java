import java.util.Arrays;

/**
 * User: tcz
 * Date: 13-1-14
 * Time: 下午9:26
 */
public class Street {
    String cellString;

    Street(String cellString) {
        if (cellString.length() == 13 || cellString.length() == 6)
            this.cellString = cellString;
    }

    Street(char ch, int i) {
        if (i== 13 || i== 6){
            char[] cells = new char[i];
            Arrays.fill(cells,ch);
            this.cellString = new String(cells);
        }
    }
}
