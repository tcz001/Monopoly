import java.awt.*;
import java.util.Random;

/**
 * User: tcz
 * Date: 13-1-15
 * Time: 下午7:13
 */
public class Player {
    int id;
    String name;
    Color color;
    int property;
    int point;
    int bomb;
    int block;

    Player(int id, int property) {
        this.id = id;
        switch (id){
            case 1: name="钱夫人";color=Color.BLUE;break;
            case 2: name="阿土伯";color=Color.ORANGE;break;
            case 3: name="孙小美";color=Color.RED;break;
            case 4: name="金贝贝";color=Color.YELLOW;break;
        }
        this.property = property;
        this.point=0;
        this.bomb=0;
        this.block=0;
    }
    int roll(){
        return (new Random().nextInt(6))+1;
    }
}
