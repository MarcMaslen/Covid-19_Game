package Project.Main;

import java.awt.*;

public class Help {
    public Rectangle Menu = new Rectangle(CovidGame.WIDTH /2 + 380, 450, 200, 50);

    public void render (Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        Font font = new Font("arial", Font.BOLD, 50);
        Font font2 = new Font("arial", Font.ITALIC, 30);
        Font font3 = new Font("arial", Font.ITALIC, 20);
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("Help Page - How to play", CovidGame.WIDTH/2 + 210, 100);
        g.setFont(font2);
        g.drawString("W - Up" , CovidGame.WIDTH /2 + 230, 200);
        g.drawString("A - Left" , CovidGame.WIDTH /2 + 230, 250);
        g.drawString("S - Down" , CovidGame.WIDTH /2 + 230, 300);
        g.drawString("D - right" , CovidGame.WIDTH /2 + 230, 350);
        g.drawString("Important Message: ", CovidGame.WIDTH /2 + 500, 230);
        g.setFont(font3);
        g.drawString("COVID-19 is Real, Make sure", CovidGame.WIDTH /2 + 500, 260);
        g.drawString("to wash your hand and keep", CovidGame.WIDTH /2 + 500, 290);
        g.drawString("your distance from people,", CovidGame.WIDTH /2 + 500, 320);
        g.drawString("it will save lives!", CovidGame.WIDTH /2 + 500, 350);
        g.setFont(font);
        g.drawString("Menu", Menu.x +30, Menu.y+43);
        g2.draw(Menu);
    }

}
