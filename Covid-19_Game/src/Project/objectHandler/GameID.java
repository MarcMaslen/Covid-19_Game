package Project.objectHandler;

import java.awt.*;

public enum GameID {
    Player(),
    Enemy(),
    Crate(),
    Block(),
    Sanitizer();
    public static Object GameObject;
    ;

    public abstract static class GameObject {

        //Here I have used protected methods so they can be used in subclasses as well.
        protected GameID ID;
        protected int x, y;
        protected float velocityX = 0, velocityY = 0;

        public GameID getID() {
            return ID;
        }

        //This is my game objects class that allows me to encapsulate my objects within my game.
        public GameObject(int x, int y, GameID ID) {
            this.x = x;
            this.y = y;
            this.ID = ID;
        }

        // These are the getters and setters for my game objects
        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        //this is to update the game object while its running
        public abstract void Update();
        //this is to render each one of my game objects within the game
        public abstract void render(Graphics g);
        //this is to handle collision within my game and the game objects
        public abstract Rectangle getBounds();


    }
}
