import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: tcz
 * Date: 13-1-14
 * Time: 下午8:26
 * To change this template use File | Settings | File Templates.
 */
public class Map {
    ArrayList<Street> streets;
    final int width=29,height=8;
    Map(ArrayList<Street> streets){
        this.streets = streets;
    }
    public void print(){
        System.out.println("S"+streets.get(0).cellString+"H"+streets.get(1).cellString+"T");
        for (int i=0;i<height-2;i++){
            char[] cells = new char[width-2];
            Arrays.fill(cells, ' ');
            System.out.println("$" + new String(cells) + streets.get(2).cellString.charAt(i));
        }
        System.out.println("M"+streets.get(3).cellString+"P"+streets.get(4).cellString+"G");
    }
}
