package model.map;
import org.junit.*;

import java.util.ArrayList;

/**
 * User: tcz
 * Date: 13-1-14
 * Time: 下午10:02
 */
public class MapTest {
    Map map;
    ArrayList<Street> streets = new ArrayList<Street>();
    @Before
    public void init(){
        Street street;
        street = new Street('0',13,200);
        streets.add(street);
        street = new Street('0',13,200);
        streets.add(street);
        street = new Street('0',6,500);
        streets.add(street);
        street = new Street('0',13,300);
        streets.add(street);
        street = new Street('0',13,300);
        streets.add(street);
    }
    @Test
    public void testPrint(){
        init();
        map = new Map(streets);
    }
}
