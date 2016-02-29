/**
 * Created by Trung Chjp on 2/27/2016.
 */
import java.util.Scanner;
public class main {
    public static void main (String [] args){
        GameWindow game=new GameWindow();
        Thread thread =new Thread(game);
        thread.start();
    }
}
