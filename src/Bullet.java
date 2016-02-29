import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Trung Chjp on 2/29/2016.
 */
public class Bullet {

    public BufferedImage sprite;
    public int positionX;
    public int positionY;
    public int direction;
    public int dam;
    private int speed;

    public Bullet(int positionX,int positionY, int direction, int dam, int speed, BufferedImage sprite){
        this.positionX = positionX + 30;
        this.positionY = positionY - 30;
        this.direction = direction;
        this.dam = dam;
        this.speed = speed;
        this.sprite = sprite;
    }

    public void move(){
        if(direction==0){

        }
        if( direction == 1 ){
            this.positionY-=this.speed;
        }else if( direction== 2 ){
            this.positionY+=this.speed;
        }else if( direction == 3 ){
            this.positionX-=this.speed;
        }else if( direction == 4 ){
            this.positionX+=this.speed;
        }
    }

    public void draw(Graphics g)
    {
        g.drawImage(this.sprite,this.positionX,this.positionY,null);

    }

}
