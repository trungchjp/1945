import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Plane {

    public int positionX;
    public int positionY;
    public int speed;
    public int HP;
    public int Dam;
    public int type;
    public BufferedImage sprite;
    public int direction;
    public MouseEvent e;
    public BulletManager bulletManager;
    public int bulletSpeed;

    public void move(){

        if (this.type == 0){
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
        } else {
            this.positionX = this.e.getX();
            this.positionY = this.e.getY();
        }
    }

    public void update()
    {
        this.move();
    }
    public void draw(Graphics g)
    {
        g.drawImage(this.sprite,this.positionX,this.positionY,null);

    }

}
