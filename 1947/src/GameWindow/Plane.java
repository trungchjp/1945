package GameWindow;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Trung Chjp on 3/3/2016.
 */
public class Plane extends PlaneAbstract {



    int direction;
    MouseEvent mouseEvent;



    public Plane(int positionX, int positionY, int speed, int type) {
        super(positionX, positionY);
        this.speed = speed;
        this.type = type;
        this.bulletManager = new BulletManager();
        if( this.type == 1 ){
            try {
                this.sprite = ImageIO.read(new File("Resouces/PLANE4.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if( this.type == 2 ){
            try {
                this.sprite = ImageIO.read(new File("Resouces/PLANE3.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void shot(){
        Bullet bullet = new Bullet(this.positionX, this.positionY, this.speed,1);
        bulletManager.add(bullet);
    }

    public void move() {
        if( this.type == 1 ){
            if (direction == 0) {
            }
            if (direction == 1) {
                this.positionY -= this.speed;
            } else if (direction == 2) {
                this.positionY += this.speed;
            } else if (direction == 3) {
                this.positionX -= this.speed;
            } else if (direction == 4) {
                this.positionX += this.speed;
            }
        } else if( this.type == 2 ){
            this.positionX = mouseEvent.getX();
            this.positionY = mouseEvent.getY();
        }
    }

    public void update(){
        this.move();
    }

    public void draw(Graphics g){
        g.drawImage(this.sprite, this.positionX, this.positionY, null);
        this.bulletManager.draw(g);
    }
}
