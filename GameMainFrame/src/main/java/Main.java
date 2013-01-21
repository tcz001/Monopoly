import enigma.console.*;
import enigma.console.Console;
import enigma.core.Enigma;

import java.awt.Color;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        console.setTextAttributes(new TextAttributes(Color.BLUE));
        System.out.println("钱夫人>\t");
        bufferedReader.readLine();
        console.setTextAttributes(new TextAttributes(Color.YELLOW));
        System.out.println("阿土伯>\t");
        bufferedReader.readLine();
    }
    private static final Console console = Enigma.getConsole("helloworld");
}
