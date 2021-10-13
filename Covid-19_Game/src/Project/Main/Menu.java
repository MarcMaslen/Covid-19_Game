package Project.Main;

import Project.states.states;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Menu implements MouseListener, MouseMotionListener {



    public Rectangle Play = new Rectangle(CovidGame.WIDTH / 2 + 150, 150, 300, 50);
    public Rectangle Leaderboards = new Rectangle(CovidGame.WIDTH / 2 + 150, 250, 300, 50);
    public Rectangle Help = new Rectangle(CovidGame.WIDTH / 2 + 2 +150, 350, 300, 50);
    public Rectangle Quit = new Rectangle(CovidGame.WIDTH / 2 + 150, 450, 300, 50);

    public void render(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        Font font = new Font("arial", Font.BOLD, 50);
        Font font3 = new Font("arial", Font.ITALIC, 20);
        Font font2 = new Font("arial", Font.ITALIC, 15);
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("COVID-19 - Social Distance Game", CovidGame.WIDTH / 2 + 120, 100);

        Font font1 = new Font("arial", Font.BOLD, 40);
        g.setFont(font1);
        g.setColor(Color.black);
        g.drawString("Play", Play.x + 110, Play.y + 37);
        g2.draw(Play);
        g.drawString("LeaderBoards", Leaderboards.x + 25, Leaderboards.y + 37);
        g2.draw(Leaderboards);
        g.drawString("Help", Help.x + 110, Help.y + 37);
        g2.draw(Help);
        g.drawString("Quit", Quit.x + 110, Quit.y + 37);
        g2.draw(Quit);
        g.drawString("Important Message: ", CovidGame.WIDTH /2 + 500, 230);
        g.setFont(font3);
        g.drawString("COVID-19 is Real, this game", CovidGame.WIDTH /2 + 500, 260);
        g.drawString("is to demonstrate how fast COVID", CovidGame.WIDTH /2 + 500, 290);
        g.drawString("spreads and the important of", CovidGame.WIDTH /2 + 500, 320);
        g.drawString("Social Distancing!", CovidGame.WIDTH /2 + 500, 350);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }


    public void mousePressed(MouseEvent e) {
        int mX = e.getX();
        int mY = e.getY();

        //-------------------------------------------------------------
        //These if statements outline the area of the screen in which when pressed
        //will do what the button says
        //-------------------------------------------------------------
        //this outlines the Game button to play the game
        if (mX >= CovidGame.WIDTH / 2 + 150 && mX <= CovidGame.WIDTH / 2 + 450) {
            if (mY >= 150 && mY <= 200) {
                CovidGame.state = states.Game;
                System.out.println("ok");
            }
        }

        //This outlines the Quit button
        if (mX >= CovidGame.WIDTH / 2 + 150 && mX <= CovidGame.WIDTH / 2 + 450) {
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
