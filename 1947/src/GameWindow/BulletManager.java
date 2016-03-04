package GameWindow;

import java.awt.*;
import java.util.Vector;

/**
 * Created by Trung Chjp on 3/3/2016.
 */
public class BulletManager {

    public Vector<Bullet> bulletVector;

    public BulletManager(){
        bulletVector = new Vector<Bullet>();
    }

    public void add(Bullet b){
        this.bulletVector.add(b);
    }

    public void update(){
        for(Bullet b : this.bulletVector){
            b.update();
        }
    }

    public void draw(Graphics g){
        for(Bullet b : this.bulletVector){
            b.draw(g);
        }
    }
}
