package Project.Main;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class EndScreen{
        public Rectangle Menu = new Rectangle(CovidGame.WIDTH / 2 + 370, 450, 200, 50);

        public void render (Graphics g){


                try {
                        // this scans the Score txt file and puts all my scores into an array
                        //then scan each line of the array.
                        Scanner scan = new Scanner(new File("Score.txt"));
                        ArrayList<String> list = new ArrayList<String>();
                        while (scan.hasNext()){
                                list.add(scan.next());
                        }
                        scan.close();



                        Graphics2D g2 = (Graphics2D) g;

                        //These are the fonts for my Endscreen
                        Font font = new Font("arial", Font.BOLD, 50);
                        Font font4 = new Font("arial", Font.BOLD, 20);
                        Font font1 = new Font("arial", Font.ITALIC, 25);
                        Font font3 = new Font("arial", Font.ITALIC, 40);

                        //This is everything that is drawn on my end screen
                        g.setFont(font);
                        g.setColor(Color.BLACK);
                        g.drawString("Game Over", CovidGame.WIDTH / 2 + 350, 100);
                        g.setFont(font1);
                        g.drawString("Remember to Social Distance, you dont know who has COVID-19", CovidGame.WIDTH / 2 + 120, 150);
                        g.setFont(font3);
                        //this is for my score and displays the last score of the txt file, this is always the last game played
                        g.drawString("Your Score: " + list.get(list.size() - 1), CovidGame.WIDTH / 2 + 330, 270);
                        g.setFont(font4);
                        g.drawString("Head back to the main Menu and check leaderboards ", CovidGame.WIDTH / 2 + 240, 400);
                        g.drawString("to see if you made the top 5, or Play Again!!", CovidGame.WIDTH / 2 + 270, 420);
                        g.setFont(font);
                        g.drawString("Menu", Menu.x + 35, Menu.y + 42);
                        g2.draw(Menu);
                } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                }
        }
}
