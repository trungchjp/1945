package GameWindow;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Trung Chjp on 3/4/2016.
 */
public abstract class PlaneAbstract extends GameObject {

    int speed;
    int type;
    BufferedImage sprite;
    BulletManager bulletManager;

    public PlaneAbstract( int speed, int type){
        super();
        this.speed = speed;
        this.type = type;
    }

    public abstract void move();

    public abstract void update();

    public abstract void draw(Graphics g);
}
