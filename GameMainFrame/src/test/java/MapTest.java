import org.junit.*;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: tcz
 * Date: 13-1-14
 * Time: 下午10:02
 * To change this template use File | Settings | File Templates.
 */
public class MapTest {
    Map map;
    ArrayList<Street> streets = new ArrayList<Street>();
    @Before
    public void init(){
        Street street;
        street = new Street('0',13);
        streets.add(street);
        street = new Street('0',13);
        streets.add(street);
        street = new Street('0',6);
        streets.add(street);
        street = new Street('0',13);
        streets.add(street);
        street = new Street('0',13);
        streets.add(street);
    }
    @Test
    public void testPrint(){
        init();
        map = new Map(streets);
        map.print();
    }
}
