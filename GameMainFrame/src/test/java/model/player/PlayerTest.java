package model.player;

import model.cell.BuildingCell;
import model.gamepad.GamePadTest;
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
    ArrayList<Player> players = new ArrayList<>();

    GamePadTest gamePadTest = new GamePadTest();

    @Before
    public void setUp() throws Exception {
        for (int i = 0; i < 4; i++) players.add(i, new Player(i + 1, 1000));
        gamePadTest.setUp();
    }

    @Test
    public void testRoll() {
        assert players.get(3).getId() == 4;
        assert players.get(3).getColor() == Color.YELLOW;
        for (int i = 0; i < 100; i++)
            assert (players.get(3).roll(gamePadTest.getGamePad()) >= 1 && players.get(3).roll(gamePadTest.getGamePad()) <= 6);
    }

    @Test
    public void testSentToHospital() throws Exception {
        this.players.get(1).sentToHospital();
        assert this.players.get(1).isInHospital > 0;
    }

    @Test
    public void testSentToPrison() throws Exception {
        this.players.get(1).sentToPrison();
        assert this.players.get(1).isInPrison > 0;
    }

    @Test
    public void testSell() {
        BuildingCell buildingCell = (BuildingCell) this.gamePadTest.getGamePad().map.cells.get(4);
        buildingCell.boughtBy(this.players.get(1));
        int before = this.players.get(1).property.getMoney();
        players.get(1).sell(gamePadTest.getGamePad(), 4);
        int after = this.players.get(1).property.getMoney();
        assert ((before + buildingCell.getRawPrice() * 2) == after);
    }
}
