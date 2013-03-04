package model.tool;

import java.awt.*;

/**
 * User: tcz
 * Date: 13-2-19
 * Time: 下午7:55
 */
public class Block extends Tool {
    public Block() {
        super('|', Color.RED, 100, -1);
    }

    public Block(int position) {
        super('|', Color.RED, 100, position);
    }
}
