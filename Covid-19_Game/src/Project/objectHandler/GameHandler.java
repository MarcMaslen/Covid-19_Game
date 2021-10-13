package Project.objectHandler;

import java.awt.*;
import java.util.LinkedList;

public class GameHandler {

    //This links all my objects together which is really helpful for creating them.
    // With this linked list we extend GameObject class
    public LinkedList<GameID.GameObject> objects = new LinkedList<GameID.GameObject>();
    private boolean up = false, down = false, left = false, right = false;

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void update() {
        for (int i = 0; i < objects.size(); i++) {
            GameID.GameObject tempObj = objects.get(i);

            tempObj.Update();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < objects.size(); i++) {
            GameID.GameObject tempObj = objects.get(i);

            tempObj.render(g);

    }
    }

    // Within the Handler we can add and remove objects to our list
    public void addObj(GameID.GameObject tempObj) {
        objects.add(tempObj);
    }

    public void removeObj(GameID.GameObject tempObj) {
        objects.remove(tempObj);
    }
}
