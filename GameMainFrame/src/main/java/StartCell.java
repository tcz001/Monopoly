import java.awt.*;
import enigma.console.TextAttributes;
/**
 * User: tcz
 * Date: 13-2-2
 * Time: 上午11:06
 */
public class StartCell extends Cell{
    StartCell(){
        super('S');
    }
    @Override
    void action() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    void print(GamePad gamePad) {
        gamePad.console.setTextAttributes(new TextAttributes(Color.LIGHT_GRAY));
        System.out.print(mark);
    }
}
