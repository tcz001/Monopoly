package model.toy;

import java.awt.*;

/**
 * User: tcz
 * Date: 13-2-19
 * Time: 下午7:55
 */
public class Block extends Toy {
    public Block(){
        super(1,'|',Color.RED,-1);
    }
    public Block(int position){
        super(1,'|',Color.RED,position);
    }
    public Block(int id, char mark, Color color, int position) {
        super(id, mark, color, position);
    }
}
