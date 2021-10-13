package Project.Characters;

import Project.Main.CovidGame;
import Project.objectHandler.GameHandler;
import Project.objectHandler.GameID;
import Project.states.states;

import java.awt.*;
import java.awt.image.BufferedImage;


//This class is the player. This is to update, render and make the player functional.
public class Survivor extends GameID.GameObject {

    private GameHandler handler;
    private BufferedImage SprintSheet = null;


    public Survivor(int x, int y, GameID ID, GameHandler handler) {
        super(x, y, ID);
        this.handler = handler;
    }


    public void Update() {
        x += velocityX;
        y += velocityY;

        //calls the collision method
        collision();

        //movement
        //moves up
        if (handler.isUp()) velocityY = -5;
        else if (!handler.isDown()) velocityY =0;

        //moves down
        if (handler.isDown()) velocityY =5;
        else if (!handler.isUp()) velocityY = 0;

        //moves right
        if (handler.isRight()) velocityX = 5;
        else if (!handler.isLeft()) velocityX =0;

        //moves left
        if (handler.isLeft()) velocityX = -5;
        else if (!handler.isRight()) velocityX =0;

    }

    // This method is used for player collision so if the play interacts with any other objects
    private void collision() {

        // This stops us from being able to leave the map
        // and other objects in the block class.
        for (int i = 0; i < handler.objects.size(); i++) {
            GameID.GameObject tempobj = handler.objects.get(i);
            if (tempobj.getID() == GameID.Block) {
                if (getBounds().intersects(tempobj.getBounds())) {
                    x += velocityX * -1;
                    y += velocityY * -1;
                }

                    }

            // this is used for players health if he collides with an enemy he loses HP
            // also once the players health hits 0 he loses but when he enters the end
            //state he goes back to 100, so when the game in entered again he isnt dead.
            if (tempobj.getID() == GameID.Enemy) {
                if (getBounds().intersects(tempobj.getBounds())) {
                    CovidGame.Health--;
                    if (CovidGame.Health == 0) {
                        CovidGame.state = states.end;
                        CovidGame.Health = 100;

                    }
                }
            }

        }
    }

    // Renders the player blue with a set width and height
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x,y,32,32);

    }

    // This gets the bound of the players or lets say the hitbox of the player for the enemy's.
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }
}
