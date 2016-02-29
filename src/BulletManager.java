import java.awt.*;
import java.lang.reflect.Array;
import java.util.Vector;

/**
 * Created by Trung Chjp on 2/29/2016.
 */
public class BulletManager {
    public Vector<Bullet> bulletVector;

    public BulletManager(){
        this.bulletVector = new Vector<Bullet>();
    }

    public void add(Bullet b){
        this.bulletVector.add(b);
    }

    public void update(){
        for (Bullet b : this.bulletVector) {
            b.move();
        }
    }

    public void draw(Graphics g)
    {
        for (Bullet b : this.bulletVector) {
            b.draw(g);
        }
    }

}
