package GameWindow;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.event.KeyEvent.VK_SPACE;

/**
 * Created by Trung Chjp on 3/3/2016.
 */
public class GameWindow extends Frame implements Runnable, KeyListener, MouseMotionListener, MouseListener {

    Graphics seconds;
    Image image;
    BufferedImage background;

    Plane plane1;
    Plane plane2;

    PlaneEnemyManager planeEnemyManager;


    public GameWindow(){

        plane1 = new Plane(200,500,5,1);

        plane2 = new Plane(400,500,5,2);



        this.createPlaneEnemy();

        this.setTitle("1947");
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

        Toolkit toolkit =  Toolkit.getDefaultToolkit();
        Point hotSpot =  new  Point ( 0 , 0 );
        BufferedImage cursorImage =  new  BufferedImage ( 1 ,  1 ,  BufferedImage . TRANSLUCENT );
        Cursor invisibleCursor = toolkit . createCustomCursor ( cursorImage , hotSpot ,  "InvisibleCursor" );
        setCursor ( invisibleCursor );

        try {
            background = ImageIO.read(new File("Resouces/Background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }



        this.addKeyListener(this);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
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
        g.drawImage(background, 0, 0, null);
        plane1.draw(g);
        plane2.draw(g);
        planeEnemyManager.draw(g);


    }

    @Override
    public void run() {
        while(true){

            plane1.update();
            plane1.bulletManager.update();
            plane2.bulletManager.update();
            planeEnemyManager.update();


            repaint();

            try{
                Thread.sleep(17);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if( e.getKeyChar() == 'w'){
            plane1.direction = 1;
        } else if( e.getKeyChar() == 's'){
            plane1.direction = 2;
        } else if( e.getKeyChar() == 'a'){
            plane1.direction = 3;
        } else if( e.getKeyChar() == 'd'){
            plane1.direction = 4;
        } else if( e.getKeyCode() == KeyEvent.VK_SPACE ){
            plane1.shot();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        plane1.direction = 0;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        plane2.mouseEvent = e;
        plane2.update();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        plane2.shot();

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

    public void createPlaneEnemy(){
        planeEnemyManager = new PlaneEnemyManager();
        PlaneEnemy planeEnemy1 = new PlaneEnemy(300,75,2,1);
        planeEnemyManager.add(planeEnemy1);
        PlaneEnemy planeEnemy2 = new PlaneEnemy(200,100,1,2);
        planeEnemyManager.add(planeEnemy2);
    }
}
