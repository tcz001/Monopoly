import model.gamepad.GamePad;
import model.map.Map;
import model.map.Street;
import model.player.Player;

import java.util.ArrayList;

/**
 * User: tcz
 * Date: 13-1-15
 * Time: 下午5:13
 */
public class Main {
    ArrayList<Street> streets = new ArrayList<>();
    Street street;
    Map map;
    ArrayList<Player> players;
    GamePad gamePad;

    public void init() throws Exception {
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
        gamePad = new GamePad(map, players);
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.init();
        main.gamePad.print();
    }
}
