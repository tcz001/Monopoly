/**
 * User: tcz
 * Date: 13-1-29
 * Time: 下午9:27
 */
public abstract class Cell {
    char mark;

    Cell(char mark) {
        this.mark = mark;
    }

    abstract void action();

    abstract void print(GamePad gamePad);
}
