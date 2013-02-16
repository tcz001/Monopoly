package model.gamepad;

import model.map.Map;
import model.map.Street;
import model.player.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * User: tcz
 * Date: 13-1-15
 * Time: 下午5:13
 */
public class GamePadTest {
    ArrayList<Street> streets = new ArrayList<>();
    Street street;
    Map map;
    ArrayList<Player> players;
    GamePad gamePad;

    @Before
    public void setUp() throws Exception {
        street = new Street('0', 13, 200);
        streets.add(street);
        street = new Street('0', 13, 200);
        streets.add(street);
        street = new Street('0', 6, 500);
        streets.add(street);
        street = new Street('0', 13, 300);
        streets.add(street);
        street = new Street('0', 13, 300);
        streets.add(street);
        map = new Map(streets);
        players = new ArrayList<>();
        players.add(new Player(1, 10000));
        players.add(new Player(2, 10000));
        players.add(new Player(3, 10000));
        players.add(new Player(4, 10000));
    }

    @Test
    public void testGamePad() throws Exception {
        setUp();
        gamePad = new GamePad(map, players);
        gamePad.print();
    }

    public void main(String[] args) throws Exception {
        testGamePad();
    }
}
