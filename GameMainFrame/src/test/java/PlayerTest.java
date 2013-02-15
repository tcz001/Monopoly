import model.player.Player;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

/**
 * User: tcz
 * Date: 13-1-15
 * Time: 下午7:14
 */
public class PlayerTest {
    ArrayList<Player> players = new ArrayList<Player>();

    @Before
    public void setup() {
        for (int i = 0; i < 4; i++) players.add(i, new Player(i + 1, 1000));
    }

    @Test
    public void testRoll() {
        assert players.get(3).getId() == 4;
        assert players.get(3).getColor() == Color.YELLOW;
        for (int i = 0; i < 100; i++) assert (players.get(3).roll() >= 1 && players.get(3).roll() <= 6);
    }
}
