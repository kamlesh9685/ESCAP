package aaaaa;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartingClass extends JPanel implements Runnable, KeyListener, MouseListener {

    private boolean ctrl_press;
    ArrayList projectiles;
    static StartingClass starter = new StartingClass();

    private static Avatar avatar;
    private BufferedImage currentSprite, m0, m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11,
            w0, w1, w2, w3, w4, w5, w6, w7, w8, w9, w10, w11, Position_r0, Position_r1, Position_r2, Position_r3,
            Position_l0, Position_l1, Position_l2, Position_l3, menu, bulletr, bulletl,
            characterJumped_r, characterJumped_l, background1, background2,
            el, e2l, er, e2r, play, exit, backButton, guideback, guidefront, guideButton, logo, start,
            deathimg, menubutton, playagain;
    private static GameBG bg1, bg2, bg3, bg4;
    public Pictures anim_r, anim_l, anim, anim_still, anim_still_r, anim_still_l,
            Positiondown_r, Positiondown_r1, Positiondown_l;
    public static Pictures hanim_l, hanim_r;

    public static BufferedImage brickdirt, grasstop, brickstone, brickrock;
    private static ArrayList<Bricks> brickarray = new ArrayList<Bricks>();

    static String State = "start";
    GameMenu MENU;
    Control GUIDE;
    EndGame DEATH;

    public static void restart() {
        avatar.getProjectiles().clear();
        brickarray.clear();
        Obstacles.enemy.clear();
        bg1 = new GameBG(0, 0);
        bg2 = new GameBG(1920, 0);
        bg3 = new GameBG(-1920, 0);
        bg4 = new GameBG(-1920 * 2, 0);
        avatar = new Avatar();
        try {
            starter.loadMap("data/map1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() throws Exception {

        setFocusable(true);
        addKeyListener(this);
        addMouseListener(this);

        // Image Setups

        characterJumped_r = ImageIO.read(new File("data/jumpedr.png"));
        characterJumped_l = ImageIO.read(new File("data/jumpedl.png"));

        background1 = ImageIO.read(new File("data/bg1.png"));
        background2 = ImageIO.read(new File("data/bg2.png"));

        brickdirt = ImageIO.read(new File("data/brickdirt.png"));
        grasstop = ImageIO.read(new File("data/grasstop.png"));
        brickstone = ImageIO.read(new File("data/brickstone.png"));
        brickrock = ImageIO.read(new File("data/brickrock.png"));

        bulletr = ImageIO.read(new File("data/bulletr.png"));
        bulletl = ImageIO.read(new File("data/bulletl.png"));

        m0 = ImageIO.read(new File("data/move/move-r (1).png"));
        m1 = ImageIO.read(new File("data/move/move-r (2).png"));
        m2 = ImageIO.read(new File("data/move/move-r (3).png"));
        m3 = ImageIO.read(new File("data/move/move-r (4).png"));
        m4 = ImageIO.read(new File("data/move/move-r (5).png"));
        m5 = ImageIO.read(new File("data/move/move-r (6).png"));
        m6 = ImageIO.read(new File("data/move/move-r (7).png"));
        m7 = ImageIO.read(new File("data/move/move-r (8).png"));
        m8 = ImageIO.read(new File("data/move/move-r (9).png"));
        m9 = ImageIO.read(new File("data/move/move-r (10).png"));
        m10 = ImageIO.read(new File("data/move/move-r (11).png"));
        m11 = ImageIO.read(new File("data/move/move-r (12).png"));

        w0 = ImageIO.read(new File("data/move/0.png"));
        w1 = ImageIO.read(new File("data/move/1.png"));
        w2 = ImageIO.read(new File("data/move/2.png"));
        w3 = ImageIO.read(new File("data/move/3.png"));
        w4 = ImageIO.read(new File("data/move/4.png"));
        w5 = ImageIO.read(new File("data/move/5.png"));
        w6 = ImageIO.read(new File("data/move/6.png"));
        w7 = ImageIO.read(new File("data/move/7.png"));
        w8 = ImageIO.read(new File("data/move/8.png"));
        w9 = ImageIO.read(new File("data/move/9.png"));
        w10 = ImageIO.read(new File("data/move/10.png"));
        w11 = ImageIO.read(new File("data/move/11.png"));

        Position_r0 = ImageIO.read(new File("data/Position/r0.png"));
        Position_r1 = ImageIO.read(new File("data/Position/r1.png"));
        Position_r2 = ImageIO.read(new File("data/Position/r2.png"));
        Position_r3 = ImageIO.read(new File("data/Position/r3.png"));

        Position_l0 = ImageIO.read(new File("data/Position/1.png"));
        Position_l1 = ImageIO.read(new File("data/Position/2.png"));
        Position_l2 = ImageIO.read(new File("data/Position/3.png"));
        Position_l3 = ImageIO.read(new File("data/Position/4.png"));

        // Menu Images

        menu = ImageIO.read(new File("data/menu1.png"));
        logo = ImageIO.read(new File("data/logo.png"));
        play = ImageIO.read(new File("data/play.png"));
        exit = ImageIO.read(new File("data/exit.png"));
        guideButton = ImageIO.read(new File("data/guideButton.png"));
        start = ImageIO.read(new File("data/intro1.png"));

        deathimg = ImageIO.read(new File("data/deathimg.png"));
        menubutton = ImageIO.read(new File("data/menuButton.png"));
        playagain = ImageIO.read(new File("data/playagainButton.png"));

        // Guide stuff
        guideback = ImageIO.read(new File("data/guideback.png"));
        guidefront = ImageIO.read(new File("data/guidefront.png"));
        backButton = ImageIO.read(new File("data/backButton.png"));

        el = ImageIO.read(new File("data/heliboy.png"));
        e2l = ImageIO.read(new File("data/heliboy2.png"));

        er = ImageIO.read(new File("data/heliboyl.png"));
        e2r = ImageIO.read(new File("data/heliboy2l.png"));

        hanim_l = new Pictures(false);
        hanim_l.addFrame(el, 500);
        hanim_l.addFrame(e2l, 500);

        hanim_r = new Pictures(false);
        hanim_r.addFrame(er, 500);
        hanim_r.addFrame(e2r, 500);

        Positiondown_r = new Pictures(true);
        Positiondown_r.addFrame(Position_r0, 20);
        Positiondown_r.addFrame(Position_r1, 20);
        Positiondown_r.addFrame(Position_r2, 20);
        Positiondown_r.addFrame(Position_r3, 20);

        Positiondown_l = new Pictures(true);
        Positiondown_l.addFrame(Position_l0, 20);
        Positiondown_l.addFrame(Position_l1, 20);
        Positiondown_l.addFrame(Position_l2, 20);
        Positiondown_l.addFrame(Position_l3, 20);

        anim_r = new Pictures(false);
        anim_r.addFrame(m0, 50);
        anim_r.addFrame(m1, 50);
        anim_r.addFrame(m2, 50);
        anim_r.addFrame(m3, 50);
        anim_r.addFrame(m4, 50);
        anim_r.addFrame(m5, 50);
        anim_r.addFrame(m6, 50);
        anim_r.addFrame(m7, 50);
        anim_r.addFrame(m8, 50);
        anim_r.addFrame(m9, 50);
        anim_r.addFrame(m10, 50);
        anim_r.addFrame(m11, 50);

        anim_l = new Pictures(false);
        anim_l.addFrame(w0, 50);
        anim_l.addFrame(w1, 50);
        anim_l.addFrame(w2, 50);
        anim_l.addFrame(w3, 50);
        anim_l.addFrame(w4, 50);
        anim_l.addFrame(w5, 50);
        anim_l.addFrame(w6, 50);
        anim_l.addFrame(w7, 50);
        anim_l.addFrame(w8, 50);
        anim_l.addFrame(w9, 50);
        anim_l.addFrame(w10, 50);
        anim_l.addFrame(w11, 50);

        anim = anim_r;

        currentSprite = m0;
    }

    public void start() {
        bg1 = new GameBG(0, 0);
        bg2 = new GameBG(1920, 0);
        bg3 = new GameBG(-1920, 0);
        bg4 = new GameBG(-1920 * 2, 0);
        avatar = new Avatar();
        MENU = new GameMenu();
        GUIDE = new Control();
        DEATH = new EndGame();

        // Initialize bricks
        try {
            loadMap("data/map1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {

            switch (State) {

                case "start":
                    break;

                case "menu":
                    break;

                case "dead":
                    break;

                case "guide":
                    break;

                case "game":
                    gameUpdate();
                    break;

            }
            repaint();

            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void gameUpdate() {

        avatar.update();
        bg1.update();
        bg2.update();
        bg3.update();
        bg4.update();
        Obstacles.update();
        updatebricks();

        hanim_l.update(50);
        hanim_r.update(50);

        ArrayList projectiles = avatar.getProjectiles();
        for (int i = 0; i < projectiles.size(); i++) {
            GameCollision p = (GameCollision) projectiles.get(i);
            if (p.isvisual() == true) {
                p.update();
            } else {
                projectiles.remove(i);
            }
        }

        for (int i = 0; i < Obstacles.enemy.size(); i++) {
            if (Obstacles.enemy.get(i).getIsDead())
                Obstacles.enemy.remove(i);
        }

        if (avatar.isJumped() && avatar.getDirection() == "right") {
            currentSprite = characterJumped_r;
        } else if (avatar.isJumped() && avatar.getDirection() == "left") {
            currentSprite = characterJumped_l;
        } else if ((avatar.getDirection() == "right") && (avatar.getmoveX() == 0) && avatar.isDucked() == false) {
            currentSprite = m0;
        } else if ((avatar.getDirection() == "left") && (avatar.getmoveX() == 0) && avatar.isDucked() == false) {
            currentSprite = w0;
        }

        else {
            if (avatar.getmoveX() < 0) {
                anim = anim_l;
            } else if (avatar.getmoveX() > 0) {
                anim = anim_r;
            } else if (avatar.isDucked() && avatar.getDirection() == "right") {
                anim = Positiondown_r;
            } else if (avatar.isDucked() && avatar.getDirection() == "left") {
                anim = Positiondown_l;
            }
            currentSprite = anim.getImage();
            anim.update(10);
        }

        if (avatar.getCenterY() > 1400) {
            State = "dead";
        }
    }

    @Override
    public void paint(Graphics g) {

        switch (State) {

            case "start":
                g.drawImage(start, 0, 0, this);
                break;

            case "menu":

                try {
                    g.drawImage(menu, (int) MENU.printX, (int) MENU.printY, this);
                    g.drawImage(logo, 510, 32, this);
                    g.drawImage(play, 60, 250, this);
                    g.drawImage(guideButton, 60, 350, this);
                    g.drawImage(exit, 60, 450, this);
                } catch (Exception e) {
                }
                break;

            case "dead":
                g.drawImage(deathimg, (int) DEATH.printX, (int) DEATH.printY, this);
                g.drawImage(menubutton, 60, 350, this);
                g.drawImage(playagain, 60, 400, this);
                break;

            case "guide":
                g.drawImage(guideback, (int) GUIDE.printX, (int) GUIDE.printY, this);
                g.drawImage(guidefront, 478, 170, this);
                g.drawImage(backButton, 20, 700, this);
                break;

            case "game":

                g.drawImage(background1, bg1.getBgX(), bg1.getBgY(), this);
                g.drawImage(background2, bg2.getBgX(), bg2.getBgY(), this);
                g.drawImage(background2, bg3.getBgX(), bg3.getBgY(), this);
                g.drawImage(background1, bg4.getBgX(), bg4.getBgY(), this);
                paintbricks(g);
                paintProjectiles(g);
                paintenemy(g);
                g.drawImage(currentSprite, avatar.getCenterX() - 61, avatar.getCenterY() - 63, this);
                break;
        }
    }

    private void updatebricks() {

        for (int i = 0; i < brickarray.size(); i++) {
            Bricks t = (Bricks) brickarray.get(i);
            t.update();
        }
    }

    private void paintenemy(Graphics g) {
        for (Obstacles i : Obstacles.enemy) {
            if (i.getCenterX() > -50 && i.getCenterX() < 1366) {
                if (i.direction == "right")
                    g.drawImage(hanim_r.getImage(), i.getCenterX() - 48, i.getCenterY() - 48, this);
                else if (i.direction == "left")
                    g.drawImage(hanim_l.getImage(), i.getCenterX() - 48, i.getCenterY() - 48, this);
            }
        }
    }

    private void paintProjectiles(Graphics g) {
        projectiles = avatar.getProjectiles();
        for (int i = 0; i < projectiles.size(); i++) {
            GameCollision p = (GameCollision) projectiles.get(i);

            if (avatar.getDirection() == "right")
                g.drawImage(bulletr, p.getX(), p.getY(), this);
            else if (avatar.getDirection() == "left")
                g.drawImage(bulletl, p.getX(), p.getY(), this);
        }
    }

    private void paintbricks(Graphics g) {
        for (int i = 0; i < brickarray.size(); i++) {
            Bricks t = (Bricks) brickarray.get(i);
            g.drawImage(t.getbrickImage(), t.getbrickX(), t.getbrickY(), this);
        }
    }

    private void loadMap(String filename) throws IOException {
        ArrayList lines = new ArrayList();
        int width = 0;
        int height = 0;

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        while (true) {
            String line = reader.readLine();
            // no more lines to read
            if (line == null) {
                reader.close();
                break;
            }

            if (!line.startsWith("!")) {
                lines.add(line);
                width = Math.max(width, line.length());

            }
        }
        height = lines.size();

        for (int j = 0; j < 20; j++) {
            String line = (String) lines.get(j);
            for (int i = 0; i < width; i++) {

                if (i < line.length()) {
                    char ch = line.charAt(i);
                    if (ch == '*') {
                        Obstacles.enemy.add(new Obstacles(i * 40, j * 40 - 80));
                    } else {
                        Bricks t = new Bricks(i, j, Character.getNumericValue(ch));
                        brickarray.add(t);
                    }
                }

            }
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (State == "start") {
            if (e.getKeyCode() == KeyEvent.VK_SPACE)
                State = "menu";
        }

        if (State == "guide") {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_ESCAPE:
                    State = "menu";
                    break;
            }
        }
        if (State == "game") {

            switch (e.getKeyCode()) {

                case KeyEvent.VK_ESCAPE:
                    State = "menu";
                    break;

                case KeyEvent.VK_UP:
                    System.out.println("Move up");
                    break;

                case KeyEvent.VK_DOWN:
                    avatar.setDucked(true);
                    break;

                case KeyEvent.VK_LEFT:
                    avatar.moveLeft();
                    break;

                case KeyEvent.VK_RIGHT:
                    avatar.moveRight();
                    break;

                case KeyEvent.VK_SPACE:
                    avatar.jump();
                    break;
                case KeyEvent.VK_ENTER:
                    State = "game";
                    break;

                case KeyEvent.VK_CONTROL:
                    ctrl_press = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                break;

            case KeyEvent.VK_DOWN:
                if (State == "game") {
                    Positiondown_r.currFrame = 0;
                    Positiondown_l.currFrame = 0;
                    avatar.setDucked(false);
                }
                break;

            case KeyEvent.VK_LEFT:
                if (State == "game")
                    avatar.stopLeft();
                break;

            case KeyEvent.VK_RIGHT:
                if (State == "game")
                    avatar.stopRight();
                break;

            case KeyEvent.VK_SPACE:
                if (State == "game") {
                    avatar.setMovingLeft(false);
                    avatar.setMovingRight(false);
                }
                break;

            case KeyEvent.VK_CONTROL:
                if (State == "game") {
                    if (ctrl_press) {
                        avatar.shoot();
                    }
                }
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {

        switch (State) {
            case "dead":
                DEATH.mousePress(me);
                break;
            case "menu":
                MENU.mousePress(me);
                break;

            case "guide":
                GUIDE.mousePress(me);
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if (State == "menu")
            MENU.mousePress = false;
        if (State == "guide")
            GUIDE.mousePress = false;
    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

    // Getters

    public static GameBG getBg1() {
        return bg1;
    }

    public static GameBG getBg2() {
        return bg2;
    }

    public static GameBG getBg3() {
        return bg3;
    }

    public static GameBG getBg4() {
        return bg4;
    }

    public static Avatar getavatar() {
        return avatar;
    }

    public static ArrayList getbrickArray() {
        return brickarray;
    }

    // Main Function
    public static void main(String[] args) {

        JFrame frame = new JFrame("ESCAPE");
        frame.setSize(1366, 768);
        frame.setBackground(Color.black);
        frame.add(starter);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            starter.init();
            starter.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}