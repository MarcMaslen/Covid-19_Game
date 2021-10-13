package Project.Camera;

import Project.objectHandler.GameID;

public class playerCamera {

    private float x, y;

    public playerCamera(float x, float y) {
        this.x=x;
        this.y=y;
    }

    public void update(GameID.GameObject objects) {

        //sets the camera in the center of the screen

        x += ((objects.getX() - x) - 1000/2) * 0.05f;
        y += ((objects.getY() - y) - 600/2) * 0.05f;


        //limits the camera boundary's so we cant go off screen
        if (x <=0) x=0;
        if (x>= 1040) x=1040;
        if (y<=0) y=0;
        if (y>= 1450) y=1450;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
