package Project.Main;

import java.awt.*;
import java.io.*;
import java.util.*;

public class LeaderBoard {
    public Rectangle Menu = new Rectangle(CovidGame.WIDTH / 2 + 380, 450, 200, 50);
    public void render(Graphics g) {

        try {

            //This scans my scores and puts it into an array list
            //this then sorts the scores from highest to lowest and displayes the top 5 scores
            Scanner scan = new Scanner(new File("Score.txt"));
            ArrayList<String> list = new ArrayList<>();

            while (scan.hasNext()){
                list.add(scan.next());
                Collections.sort(list, Collections.reverseOrder());
            }


                Graphics2D g2 = (Graphics2D) g;

                //this is the font
                Font font = new Font("arial", Font.BOLD, 50);
                Font font2 = new Font("arial", Font.ITALIC, 30);
                Font font3 = new Font("arial", Font.ITALIC, 20);

                //this is everything tht is drawn to the leaderboard screen.
                g.setColor(Color.BLACK);
                g.setFont(font);
                g.drawString("LeaderBoards", CovidGame.WIDTH / 2 + 330, 100);
                g.setFont(font2);
                g.drawString("Top 5 best social distance times!", CovidGame.WIDTH / 2 + 290, 150);
                //These are the top 5 scores in the list after it has been sorted.
                g.drawString("Score: " + list.get(0), CovidGame.WIDTH / 2 + 220, 230);
                g.drawString("Score: " + list.get(1), CovidGame.WIDTH / 2 + 220, 265);
                g.drawString("Score: " + list.get(2), CovidGame.WIDTH / 2 + 220, 300);
                g.drawString("Score: " + list.get(3), CovidGame.WIDTH / 2 + 220, 335);
                g.drawString("Score: " + list.get(4), CovidGame.WIDTH / 2 + 220, 370);
                g.setFont(font2);
                g.drawString("Important Message: ", CovidGame.WIDTH /2 + 500, 230);
                g.setFont(font3);
                g.drawString("Make sure to follow", CovidGame.WIDTH /2 + 500, 260);
                g.drawString("The Tier system as they", CovidGame.WIDTH /2 + 500, 290);
                g.drawString("are there to keep everyone,", CovidGame.WIDTH /2 + 500, 320);
                g.drawString("Safe. Hands, Face, Space!", CovidGame.WIDTH /2 + 500, 350);
                g.setFont(font);
                g.drawString("Menu", Menu.x + 30, Menu.y + 43);
                g2.draw(Menu);
                scan.close();
                }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

    }
}
