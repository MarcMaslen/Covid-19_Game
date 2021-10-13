package Project.Characters;

import Project.objectHandler.GameID;

import java.awt.*;

public class obsticle extends GameID.GameObject {
    public obsticle(int x, int y, GameID ID) {
        super(x, y, ID);
    }


    public void Update() {

    }


    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(x,y,32,32);

    }


    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }
}
