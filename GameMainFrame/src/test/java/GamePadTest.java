import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: tcz
 * Date: 13-1-15
 * Time: 下午5:13
 * To change this template use File | Settings | File Templates.
 */
public class GamePadTest {
    ArrayList<Street> streets = new ArrayList<Street>();
    Street street;
    Map map;
    GamePad gamePad;

    @Before
    public void setUp() throws Exception {
        street = new Street('0', 13);
        streets.add(street);
        street = new Street('0', 13);
        streets.add(street);
        street = new Street('0', 6);
        streets.add(street);
        street = new Street('0', 13);
        streets.add(street);
        street = new Street('0', 13);
        streets.add(street);
        map = new Map(streets);
    }

    @Test
    public void testGamePad() throws Exception {
        setUp();
        gamePad = new GamePad(map);
        gamePad.print();
    }

    public void main(String[] args) throws Exception {
        testGamePad();
    }
}
