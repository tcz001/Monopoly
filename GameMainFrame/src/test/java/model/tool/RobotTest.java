package model.tool;

import model.gamepad.GamePadTest;
import org.junit.Test;


/**
 * User: tcz
 * Date: 13-3-4
 * Time: 下午3:02
 */
public class RobotTest {
    GamePadTest gamePadTest;
    @Test
    public void testAction() throws Exception {
        gamePadTest = new GamePadTest();
        gamePadTest.setUp();
        gamePadTest.getGamePad().tools.add(new Bomb(1));
        gamePadTest.getGamePad().tools.add(new Block(5));
        gamePadTest.getGamePad().tools.add(new Block(15));
        Robot.action(1, gamePadTest.getGamePad());
        assert (gamePadTest.getGamePad().tools.size()==1);
        assert (gamePadTest.getGamePad().tools.get(0).getPosition()==15);
    }
}
