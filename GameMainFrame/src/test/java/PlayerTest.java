import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: tcz
 * Date: 13-1-15
 * Time: 下午7:14
 * To change this template use File | Settings | File Templates.
 */
public class PlayerTest {
    ArrayList<Player> players=new ArrayList<Player>();

    @Before
    public void setup() {
        for (int i = 0; i < 4; i++) players.add(i,new Player(i,1000));
    }

    @Test
    public void testRoll() {
        assert players.get(3).id==3;
    }
}
