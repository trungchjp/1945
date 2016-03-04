package GameWindow;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.imageio.ImageIO;
import javax.sound.midi.Soundbank;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.SampleModel;
import java.io.File;
import java.io.IOException;
import java.io.SyncFailedException;

import static java.lang.Math.abs;
import static java.lang.StrictMath.sqrt;
import static java.lang.StrictMath.subtractExact;

/**
 * Created by Trung Chjp on 3/3/2016.
 */
public class PlaneEnemy extends PlaneAbstract {


    int width;
    int heigh;

    int count;




    public PlaneEnemy( int positionX, int positionY , int speed, int type ){
        super(positionX, positionY);
        this.positionX = positionX ;
        this.positionY = positionY ;
        this.speed = speed;
        this.type = type;
        this.bulletManager = new BulletManager();
        try {
            this.sprite = ImageIO.read(new File("Resouces/PLANE1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void threeShot(){
        Bullet bullet = new Bullet( this.positionX, this.positionY, 3 ,2);
        Bullet bullet2 = new Bullet( this.positionX , this.positionY, 3 ,3);
        Bullet bullet3 = new Bullet( this.positionX , this.positionY, 3 ,4);
        bulletManager.add(bullet);
        bulletManager.add(bullet2);
        bulletManager.add(bullet3);
    }

    public void doubleShot(){
        Bullet bullet = new Bullet( this.positionX, this.positionY, 3 ,2);
        Bullet bullet2 = new Bullet( this.positionX + 12, this.positionY, 3 ,2);
        bulletManager.add(bullet);
        bulletManager.add(bullet2);
    }

    public void move() {
        if ( this.type == 1) {
            this.positionX += this.speed;
            if (this.positionX <= 0) {
                this.speed = -this.speed;
            } else if (this.positionX >= 350) {
                this.speed = -this.speed;
            }
        } else if( this.type == 2 ){
            this.positionX  += this.speed;
            if (this.positionX <= 125) {
                this.speed = -this.speed;
            } else if (this.positionX >= 400) {
                this.speed = -this.speed;
            }
            this.positionY = (int) (100/75*sqrt(abs(5625 - this.positionX*this.positionX)));
            System.out.println(this.positionX +" "+ this.positionY);
        }
    }



    public void update(){
        count++;
        if(count >= 50){
            count=0;
            if( this.type == 1 ){
                this.threeShot();
            } else {
                this.doubleShot();
            }
        }
        bulletManager.update();
        this.move();
    }

    public void draw(Graphics g){
        bulletManager.draw(g);
        g.drawImage( this.sprite, this.positionX, this.positionY, this.width+50, this.heigh+50, null );
    }
}
