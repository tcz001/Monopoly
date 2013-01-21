/**
 * Created with IntelliJ IDEA.
 * User: tcz
 * Date: 13-1-15
 * Time: 下午7:13
 * To change this template use File | Settings | File Templates.
 */
public class Player {
    int id;
    String name;
    int property;
    int point;
    int bomb;
    int block;

    Player(int id, int property) {
        this.id = id;
        this.property = property;
    }
}
