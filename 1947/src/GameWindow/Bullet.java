package GameWindow;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Trung Chjp on 3/3/2016.
 */
public class Bullet extends GameObject {

    BufferedImage sprite;
    int speed;
    int type;
    int planeEnemyType;

    public Bullet(int positionX, int positionY, int speed, int type ){
        this.speed = speed;
        this.type = type;
        if( this.type == 1 ){
            this.positionX = positionX + 30;
            this.positionY = positionY - 30;
            try {
                this.sprite = ImageIO.read(new File("Resouces/DAN.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if( this.type == 2 ) {
            this.positionX = positionX + 18;
            this.positionY = positionY + 45;
            try {
                this.sprite = ImageIO.read(new File("Resouces/1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if( this.type == 3 ){
            this.positionX = positionX + 18;
            this.positionY = positionY + 45;
            try {
                this.sprite = ImageIO.read(new File("Resouces/1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if( this.type == 4 ){
            this.positionX = positionX + 18;
            this.positionY = positionY + 45;
            try {
                this.sprite = ImageIO.read(new File("Resouces/1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void move(){
        if(this.type == 1 ){
            this.positionY -= this.speed;
        } else if( this.type == 2 ){
            this.positionY += this.speed;
        } else if( this.type == 3 ){
            this.positionY += this.speed;
            this.positionX += this.speed;
        } else if( this.type == 4 ){
            this.positionY += this.speed;
            this.positionX -= this.speed;
        }
    }

    public void update(){
        this.move();
    }

    public void draw(Graphics g){
        g.drawImage(this.sprite, this.positionX, this.positionY,null);
    }


}
