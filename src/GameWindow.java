import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Trung Chjp on 2/27/2016.
 */
public class GameWindow extends Frame implements KeyListener,Runnable, MouseMotionListener, MouseListener {


    public Graphics seconds;
    public Image image;
    public BufferedImage background;
    public BufferedImage dan;

    public Plane plane1;
    public Plane plane2;


    public GameWindow(){

        //create plane 1
        plane1 = new Plane();
        plane1.positionX=150;
        plane1.positionY=300;
        plane1.speed=3;
        plane1.type = 0;
        plane1.bulletManager = new BulletManager();
        plane1.bulletSpeed = 5;

        //create plane 2
        plane2 = new Plane();
        plane2.type = 1;
        plane2.bulletManager = new BulletManager();
        plane2.bulletSpeed = 5;

        //create frame
        this.setTitle("1945");
        this.setSize(400,640);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
                repaint();
            }
        }
        );

        //set image for planes and background
        try{
            background = ImageIO.read(new File("Resouces/Background.png"));
            plane1.sprite = ImageIO.read(new File("Resouces/PLANE3.png"));
            plane2.sprite = ImageIO.read(new File("Resouces/PLANE4.png"));
            dan = ImageIO.read(new File("Resouces/DAN.png"));
        }catch (IOException e) {}


        //add mouse listener and key listener
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        this.addMouseListener(this);


        //hide cursor
        Toolkit toolkit =  Toolkit.getDefaultToolkit();
        Point hotSpot =  new  Point ( 0 , 0 );
        BufferedImage cursorImage =  new  BufferedImage ( 1 ,  1 ,  BufferedImage . TRANSLUCENT );
        Cursor invisibleCursor = toolkit . createCustomCursor ( cursorImage , hotSpot ,  "InvisibleCursor" );
        setCursor ( invisibleCursor );
    }

    @Override
    public void update(Graphics g){
        if(image == null){
            image = createImage(this.getWidth(), this.getHeight());
            seconds = image.getGraphics();
        }
        seconds.setColor(getBackground());
        seconds.fillRect(0,0, getWidth(), getHeight());
        seconds.setColor(getForeground());
        paint(seconds);
        g.drawImage(image,0,0,null);
    }


    public void paint(Graphics g){
        g.drawLine(0,0,100,100);
        g.drawImage(background,0,0,null);
        plane1.draw(g);
        plane1.bulletManager.draw(g);
        plane2.draw(g);
        plane2.bulletManager.draw(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        //update plane1's position when press a key
        if(e.getKeyChar()=='w'){
            plane1.direction=1;

        } else if(e.getKeyChar()=='s'){
            plane1.direction=2;

        } else if(e.getKeyChar()=='a'){
            plane1.direction=3;

        } else if(e.getKeyChar()=='d'){
            plane1.direction=4;
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE ){

            //create bullet and add to bullet manager vector
            Bullet newBullet = new Bullet(plane1.positionX,plane1.positionY,1,plane1.Dam,plane1.bulletSpeed,dan);
            plane1.bulletManager.add(newBullet);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        plane1.direction=0;
    }

    @Override
    public void run() {
        int x=0;
        while (true){

            //repaint plane1
            plane1.update();
            plane1.bulletManager.update();
            plane2.bulletManager.update();
            repaint();


            try{
                Thread.sleep(17);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

        //repaint plane2
        plane2.e = e;
        plane2.update();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        //create bullet and add to bullet manager vector
        Bullet newBullet = new Bullet(plane2.positionX,plane2.positionY,1,plane2.Dam,plane2.bulletSpeed,dan);
        plane2.bulletManager.add(newBullet);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
