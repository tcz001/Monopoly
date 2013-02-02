import enigma.console.TextAttributes;

import java.awt.*;

/**
 * User: tcz
 * Date: 13-2-2
 * Time: 下午2:14
 */
public class MineCell extends Cell{
    MineCell() {
        super('$');
    }

    @Override
    void action() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    void print(GamePad gamePad) {
        gamePad.console.setTextAttributes(new TextAttributes(Color.ORANGE));
        System.out.print(mark);
    }
}
