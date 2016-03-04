package GameWindow;

import java.awt.*;
import java.util.Vector;

/**
 * Created by Trung Chjp on 3/3/2016.
 */
public class PlaneEnemyManager  {


    public Vector<PlaneEnemy> planeEnemyVector;

    public PlaneEnemyManager(){
        planeEnemyVector = new Vector<PlaneEnemy>() ;
    }

    public void add(PlaneEnemy p){
        this.planeEnemyVector.add(p);
    }

    public void update(){
        for( PlaneEnemy p : this.planeEnemyVector ){

            p.update();

        }

    }

    public void draw(Graphics g){
        for( PlaneEnemy p : this.planeEnemyVector ){
            p.draw(g);
        }
    }




}
