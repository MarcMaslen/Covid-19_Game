package Project.Controls;

import Project.objectHandler.GameHandler;
import Project.objectHandler.GameID;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyboardListener extends KeyAdapter{

    GameHandler handler;
    //This just making it so the keyboard will work with the game handler.
    public KeyboardListener(GameHandler handler) {
        this.handler = handler;
    }

    //this method is if a key is pressed then it will do that thing
    //these are the arrow keys being up, down left and right.
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.objects.size(); i++) {
            GameID.GameObject tempObj = handler.objects.get(i);

            if (tempObj.getID() == GameID.Player) {
                if (key == KeyEvent.VK_UP) handler.setUp(true);
                if (key == KeyEvent.VK_DOWN) handler.setDown(true);
                if (key == KeyEvent.VK_LEFT) handler.setLeft(true);
                if (key == KeyEvent.VK_RIGHT) handler.setRight(true);


            }
        }

    }
    // this means if the key that was pressed is then released it will stop doing that action
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.objects.size(); i++) {
            GameID.GameObject tempObj = handler.objects.get(i);

            if (tempObj.getID() == GameID.Player) {
                if (key == KeyEvent.VK_UP) handler.setUp(false);
                if (key == KeyEvent.VK_DOWN) handler.setDown(false);
                if (key == KeyEvent.VK_LEFT) handler.setLeft(false);
                if (key == KeyEvent.VK_RIGHT) handler.setRight(false);


            }
        }
    }
}

