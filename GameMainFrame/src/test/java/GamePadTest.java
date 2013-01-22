import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.*;

/**
 * User: tcz
 * Date: 13-1-15
 * Time: 下午5:13
 */
public class GamePadTest {
    ArrayList<Street> streets = new ArrayList<Street>();
    Street street;
    Map map;
    ArrayList<Player> players;
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
        players= new ArrayList<Player>();
        players.add( new Player(1,1000));
        players.add( new Player(2,1000));
        players.add( new Player(3,1000));
        players.add( new Player(4,1000));
    }

    @Test
    public void testGamePad() throws Exception {
        setUp();
        gamePad = new GamePad(map,players);
        gamePad.print();
    }

    public void main(String[] args) throws Exception {
        testGamePad();
    }
}
