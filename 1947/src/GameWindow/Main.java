package GameWindow;

/**
 * Created by Trung Chjp on 3/3/2016.
 */
public class Main {
    public static void main(String[] args){

        GameWindow gameWindow = new GameWindow();
        Thread thread = new Thread(gameWindow);
        thread.start();

    }
}
