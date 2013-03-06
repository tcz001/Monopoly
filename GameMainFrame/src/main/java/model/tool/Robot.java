package model.tool;

import model.gamepad.GamePad;

import java.awt.*;
import java.util.ArrayList;

/**
 * User: tcz
 * Date: 13-2-20
 * Time: 下午5:41
 */
public class Robot extends Tool {
    public Robot() {
        super('R', Color.ORANGE, 30, -1);
    }

    public static void action(int position, GamePad gamePad) {
        ArrayList<Tool> toBeRemovedTools = new ArrayList<>();
        for (Tool tool : gamePad.tools) {
            if (tool.getPosition() >= position && tool.getPosition() <= (position + 10))
                toBeRemovedTools.add(tool);
        }
        gamePad.tools.removeAll(toBeRemovedTools);
    }
}
