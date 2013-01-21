import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: tcz
 * Date: 13-1-14
 * Time: 下午9:27
 * To change this template use File | Settings | File Templates.
 */
public class StreetTest {
    @Test
    public void testCellString(){
        Street street=new Street("0000000000000");
        assert street.cellString.length() == 13;
    }
}
