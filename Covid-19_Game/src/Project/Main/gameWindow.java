package Project.Main;

import javax.swing.*;
import java.awt.*;


public class gameWindow {


    public gameWindow(int width, int height, String title, CovidGame game) {
        JFrame Game = new JFrame(title);
        Game.setPreferredSize(new Dimension(width, height));
        Game.setMaximumSize(new Dimension(width, height));
        Game.setMinimumSize(new Dimension(width, height));
        Game.add(game);
        Game.setResizable(false);
        Game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Game.setLocationRelativeTo(null);
        Game.setVisible(true);



    }




}
