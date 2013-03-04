package model.cell;
import org.junit.Test;

import model.player.Player;

/**
 * Created with IntelliJ IDEA.
 * User: tcz
 * Date: 13-2-16
 * Time: 下午9:19
 */
public class BuildingCellTest {
    BuildingCell buildingCell = new BuildingCell(200);
    Player player1 = new Player(1, 1000), player2 = new Player(2, 1000);

    @Test
    public void testAction() throws Exception {
        buildingCell.boughtBy(player2);
        buildingCell.charge(player1);
        assert player2.property.getMoney()==1000;
        assert player1.property.getMoney()==800;
    }
    @Test
    public void testLeverUp() throws Exception {
        buildingCell.boughtBy(player2);
        assert buildingCell.charge(player1) == 200;
        assert player2.property.getMoney()==1000;
        buildingCell.leverUp();
        assert buildingCell.charge(player1) == 300;
        assert player2.property.getMoney()==1300;
        assert buildingCell.mark=='1';
    }
}
