import enigma.console.Console;
import enigma.console.TextAttributes;
import enigma.core.Enigma;

import java.awt.Color;
import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: tcz
 * Date: 13-1-15
 * Time: 下午5:11
 * To change this template use File | Settings | File Templates.
 */
public class GamePad {
    static Map map;

    GamePad(Map map) {
        this.map = map;
    }

   public void print() throws IOException {
        while (true) {
            map.print();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            console.setTextAttributes(new TextAttributes(Color.BLUE));
            System.out.println("钱夫人>\t");
            bufferedReader.readLine();
            console.setTextAttributes(new TextAttributes(Color.YELLOW));
            System.out.println("阿土伯>\t");
            bufferedReader.readLine();
        }
    }

    private static final Console console = Enigma.getConsole("helloworld");
}


