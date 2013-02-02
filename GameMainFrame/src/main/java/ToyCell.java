import enigma.console.TextAttributes;

import java.awt.*;

/**
 * User: tcz
 * Date: 13-2-2
 * Time: 上午11:43
 */
public class ToyCell extends Cell{
    ToyCell(){
        super('T');
    }
    @Override
    void action() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    void print(GamePad gamePad) {
        gamePad.console.setTextAttributes(new TextAttributes(Color.YELLOW));
        System.out.print(mark);
    }
}
