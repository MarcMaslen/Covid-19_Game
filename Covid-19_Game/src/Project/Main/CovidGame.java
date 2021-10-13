package Project.Main;

import Project.Camera.playerCamera;
import Project.Characters.Enemy;
import Project.Characters.Survivor;
import Project.Characters.obsticle;
import Project.Controls.KeyboardListener;
import Project.Controls.MouseListener;
import Project.graphics.BufferedImageLoader;
import Project.objectHandler.GameHandler;
import Project.objectHandler.GameID;
import Project.states.states;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.*;

public class CovidGame extends Canvas implements Runnable {
    public static int second = 0;
    private Thread thread;
    private boolean programOn = false;
    private final GameHandler handler;
    private BufferedImage SprintSheet = null;
    private final playerCamera cam;
    private final Menu menu;
    private final EndScreen end;
    private final Help help;
    private final LeaderBoard leader;

    public static int Health = 100;

    // -----------------------------------------
    // This creates our game widow with a few properties so it functions properly
    // This also starts our game and this is what it runs from.
    // -----------------------------------------

    public static states state;

    public CovidGame() {
        new gameWindow(1000, 600, "Covid-19: Keep Your Distance", this);
        state = states.Menu;
        menu = new Menu();
        end = new EndScreen();
        help = new Help();
        leader = new LeaderBoard();
        startGame();
        handler = new GameHandler();
        cam = new playerCamera(0, 0);
        this.addKeyListener(new KeyboardListener(handler));
        this.addMouseListener(new MouseListener());
        BufferedImageLoader load = new BufferedImageLoader();
        SprintSheet = load.loadImg("/map.png");
        LoadMap(SprintSheet);
    }


    //This starts the game thread to allow it to run and play
    private void startGame() {
        programOn = true;
        thread = new Thread(this, "GameThreading");
        thread.start();
    }

    //This stops the game implementing a try and catch was to handle any errors that happen
    private void stopGame() {
        programOn = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // ------------------------------------------------
    // This handle FPS and limits it to 60 frames a second
    // and allows a few thousand renders with it.
    // This was used in Minecraft to manage the FPS,
    // I take no credit for the public void run as it
    // was simply a way for me to manage FPS better.
    // although, I have changed parts of it to make it my own
    // ------------------------------------------------

    public void run() {
        this.requestFocus();
        long nanoTime = System.nanoTime();
        double Hertz = 60.0;
        double ns = 1000_000_000 / Hertz;
        double delta = 0;
        long time = System.currentTimeMillis();
        int FPS = 0;

        while (programOn) {
            long present = System.nanoTime();
            delta += (present - nanoTime) / ns;
            nanoTime = present;
            while (delta >= 1) {
                update();
                delta--;
            }
            render();
            FPS++;


            if (System.currentTimeMillis() - time > 1000) {
                time += 1000;
                FPS = 0;


            }//System.out.println("FPS - " + FPS);
        }
        stopGame();
    }

    // This constantly updates the game as it runs
    public void update() {
        if (state == states.Game) {
            for (int i = 0; i < handler.objects.size(); i++) {
                if (handler.objects.get(i).getID() == GameID.Player) {
                    cam.update(handler.objects.get(i));
                }
            }
            handler.update();

        }
    }


    //This renders the map and all the states for the game.
    public void render() {
        BufferStrategy Img = this.getBufferStrategy();

        if (Img == null) {
            this.createBufferStrategy(3);
            return;
        }


        Graphics g = Img.getDrawGraphics();
        Graphics2D g2 = (Graphics2D) g;


        //This the state of when the player is in the Game
        Font font = new Font("arial", Font.BOLD, 30);
        if (state == states.Game) {
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, 1000, 600);
            second++;
            g2.translate(-cam.getX(), -cam.getY());
            handler.render(g);
            g2.translate(cam.getX(), cam.getY());

            g.setColor(Color.GRAY);
            g.fillRect(40, 20, 200, 32);
            g.setColor(Color.green);
            g.fillRect(40,20, Health*2, 32);
            g.setColor(Color.BLACK);
            g.drawRect(40,20, 200, 32);

            g.setFont(font);
            g.setColor(Color.white);
            g.drawString("Covid Is spreading fast, Stay away from people!", CovidGame.WIDTH / 2 + 150, 550);
            g.drawString("score " + second, CovidGame.WIDTH / 2 + 450, 40);

            if (Health == 1) {
                Print();
            }

            //This is for the main Menu
        } else if (state == states.Menu) {
            ((Graphics2D) g).setStroke(new BasicStroke(2));
            g.setColor(Color.cyan);
            g.fillRect( 0, 0, 1000, 600);
            menu.render(g);
            second = 0;

            //This is for the End screen
        } else if (state == states.end) {
            g.setColor(Color.cyan);
            g.fillRect(0, 0, 1000, 600);
            end.render(g);

            //This is the help page
        } else if (state == states.Help) {
            g.setColor(Color.cyan);
            g.fillRect(0, 0, 1000, 600);
            help.render(g);


            //this is fot the leaderboards
        } else if (state == states.Leader) {
            g.setColor(Color.CYAN);
            g.fillRect(0, 0, 1000, 600);
            leader.render(g);
        }

        g.dispose();
        Img.show();
    }


    //Load the Map
    public void LoadMap(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();


        // this puts it in a for loop to load the game constantly.
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int pixels = img.getRGB(x, y);
                int red = (pixels >> 16) & 0xff;
                int green = (pixels >> 8) & 0xff;
                int blue = (pixels) & 0xff;

                //This is specifying the walls of the LEVEL
                if (red == 255)
                    handler.addObj(new obsticle(x * 32, y * 32, GameID.Block));

                //This is specifying the Player of the LEVEL
                if (blue == 255)
                    handler.addObj(new Survivor(x * 32, y * 32, GameID.Player, handler));


                //This is specifying the Enemy of the LEVEL
                if (green == 255)
                    handler.addObj(new Enemy(y * 32, x * 32, GameID.Enemy, handler));
            }
        }
    }

    //This is my scoring method and it takes the score the player gets and inputing it into a text file
    public void Print() {
            try {
                PrintWriter wr = new PrintWriter(new FileWriter("Score.txt", true));
                wr.write( CovidGame.second + "\n");
                wr.close();


            } catch (IOException e) {
                System.out.println("Missing File");
            }
        }


    // this is the main
    public static void main(String[] args) {
        new CovidGame();
    }
}


