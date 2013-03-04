package model.tool;

import java.awt.*;

/**
 * User: tcz
 * Date: 13-2-19
 * Time: 下午5:57
 */
public class Bomb extends Tool {
    public Bomb() {
        super('B', Color.RED, 100, -1);
    }

    public Bomb(int position) {
        super('B', Color.RED, 100, position);
    }
}