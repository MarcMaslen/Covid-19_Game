package Project.Characters;


import Project.objectHandler.GameHandler;
import Project.objectHandler.GameID;

import java.awt.*;

public class Enemy extends GameID.GameObject {
    float dist, diffrentX, diffrentY;
    private GameHandler handler;
    public Enemy(int x, int y, GameID ID, GameHandler handler) {
        super(x, y, ID);
        this.handler = handler;
    }


    public void Update() {
        x += velocityX;
        y += velocityY;

        collision();

        for (int i = 0; i < handler.objects.size(); i++) {
                GameID.GameObject tempObj = handler.objects.get(i);

                if (tempObj.getID() == GameID.Player) {
                    diffrentX = x - tempObj.getX() - getBounds().width;
                    diffrentY = y - tempObj.getY() - getBounds().height;
                    dist = (float) Math.sqrt((x - tempObj.getX()) * (x - tempObj.getX()) + (y - tempObj.getY()) * (y - tempObj.getY()));

                }
        }

        //if the enemy is within 500 blocks on me it will move towards the player.
        //the enemy has a slightly slower movement then the player however, there
        //is more enemy's then there are of the player.
        //The Enemy will jump at you if it gets too close
        if (dist < 500) {
            velocityX = ((-3 / dist) * diffrentX);
            velocityY = ((-3 / dist) * diffrentY);
        } else {
            velocityY = 0;
            velocityX = 0;
        }
    }

    private void collision() {
        GameID.GameObject tempobj = null;
        for (int i = 0; i < handler.objects.size(); i++) {
            tempobj = handler.objects.get(i);
            if (tempobj.getID() == GameID.Block) {
                if (getBounds().intersects(tempobj.getBounds())) {
                    x += velocityX * -1;
                    y += velocityY * -1;
                }
            }

        }

    }



    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 32, 32);

    }


    public Rectangle getBounds() {
        return new Rectangle(x, y, 31, 31);
    }
}
