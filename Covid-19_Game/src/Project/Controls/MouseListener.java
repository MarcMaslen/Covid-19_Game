package Project.Controls;

import Project.Main.CovidGame;
import Project.states.states;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseListener implements java.awt.event.MouseListener, MouseMotionListener {
    public static states state;


    @Override
    public void mouseClicked(MouseEvent e) {

    }


    public void mousePressed(MouseEvent e) {
        int mX = e.getX();
        int mY = e.getY();


        //These if statements outline the area of the screen in which when pressed
        //will do what the button says


                //this outlines the Game button to play the game
                if (mX >= CovidGame.WIDTH / 2 + 150 && mX <= CovidGame.WIDTH / 2 + 450) {
                    if (mY >= 150 && mY <= 200) {
                        CovidGame.state = states.Game;
                        System.out.println("Game");
                    }
                }

                //This outlines the Quit button
                if (mX >= CovidGame.WIDTH / 2 + 150 && mX <= CovidGame.WIDTH / 2 + 350) {
                    if (mY >= 450 && mY <= 500) {
                        System.exit(1);
                        System.out.println("Bye");
                    }
                }

                //This outlines the Leaderboard button
                if (mX >= CovidGame.WIDTH / 2 + 150 && mX <= CovidGame.WIDTH / 2 + 450) {
                    if (mY >= 250 && mY <= 300) {
                        CovidGame.state = CovidGame.state.Leader;
                        System.out.println("Leaderboards");
                    }
                }


            //This outlines the Help button
            if (mX >= CovidGame.WIDTH / 2 + 150 && mX <= CovidGame.WIDTH / 2 + 450) {
                if (mY >= 350 && mY <= 400) {
                    CovidGame.state = CovidGame.state.Help;
                    System.out.println("Help");
                }
            }

        if (mX >= CovidGame.WIDTH / 2 + 350 && mX <= CovidGame.WIDTH / 2 + 650) {
            if (mY >= 450 && mY <= 500) {
                CovidGame.state = CovidGame.state.Menu;
                System.out.println("Menu");
            }
        }
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

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}

