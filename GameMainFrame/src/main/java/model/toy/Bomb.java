package model.toy;

import java.awt.*;

/**
 * User: tcz
 * Date: 13-2-19
 * Time: 下午5:57
 */
public class Bomb extends Toy {
    public Bomb(){
        super(1,'B',Color.RED,-1);
    }
    public Bomb(int position){
        super(1,'B',Color.RED,position);
    }
    public Bomb(int id, char mark, Color color, int position) {
        super(id, mark, color, position);
    }
}
