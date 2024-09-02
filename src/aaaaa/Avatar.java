package aaaaa;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Avatar {

    // Constants are Here
    final int JUMPSPEED = -17;
    final int MOVESPEED = 5;

    private int centerX = 501;
    private int centerY = 561;
    private boolean jump = false;
    private boolean LeftMove = false;
    private boolean RightMove = false;
    private boolean ducked = false;
    private static String direction = "right";

    private int moveX = 0;
    private int moveY = 0;
    public static Rectangle rec1 = new Rectangle(0, 0, 0, 0);
    public static Rectangle rec2 = new Rectangle(0, 0, 0, 0);
    public static Rectangle redyellow = new Rectangle(0, 0, 0, 0);
    
    public static Rectangle leftFoot = new Rectangle(0,0,0,0);
    public static Rectangle rightFoot = new Rectangle(0,0,0,0);
    
    private GameBG b1 = StartingClass.getBg1();
    private GameBG b2 = StartingClass.getBg2();
    private GameBG b3 = StartingClass.getBg3();
    private GameBG b4 = StartingClass.getBg4();

    private ArrayList<GameCollision> projectiles = new ArrayList<GameCollision>();

    public void update() {
        if (moveX == 0){
            b1.setmoveX(0);
            b2.setmoveX(0);
            b3.setmoveX(0);
            b4.setmoveX(0);
        }
        
        if (centerX <= 800 && moveX > 0) {
            centerX += moveX;
        }
        if (centerX >=400 && moveX<0){
            centerX += moveX;
        }
        
        if (moveX > 0 && centerX > 800) {
            b1.setmoveX(-MOVESPEED / 5);
            b2.setmoveX(-MOVESPEED / 5);
            b3.setmoveX(-MOVESPEED / 5);
            b4.setmoveX(-MOVESPEED / 5);
        }
         if (moveX < 0 && centerX < 400){
            b1.setmoveX(MOVESPEED / 5);
            b2.setmoveX(MOVESPEED / 5);
            b3.setmoveX(MOVESPEED / 5);
            b4.setmoveX(MOVESPEED / 5);
        }
        
        // Updates Y Position
        centerY += moveY;

        // Handles Jumping
        moveY += 1;

        if (moveY > 3){
            jump = true;
        }

        rec1.setRect(centerX -56, centerY -64	, 35, 70);
        rec2.setRect(rec1.getX(), rec1.getY() + 70, 35, 70);
        redyellow.setRect(centerX - 92, centerY - 80, 110, 180);

        leftFoot.setRect(centerX -60, centerY - 33, 5, 95);
        rightFoot.setRect(centerX -20, centerY - 33, 5, 95);
    }

    public void moveRight() {
        direction = "right";
        if (ducked == false) {
            moveX = MOVESPEED;
        }
    }

    public void moveLeft() {
        direction = "left";
        if (ducked == false) {
            moveX = -MOVESPEED;
        }
    }

    public void stopRight() {
        setMovingRight(false);
        stop();
    }

    public void stopLeft() {
        setMovingLeft(false);
        stop();
    }

    private void stop() {
        if (isMovingRight() == false && isMovingLeft() == false) {
            moveX = 0;
        }
        if (isMovingRight() == false && isMovingLeft() == true) {
            moveLeft();
        }
        if (isMovingRight() == true && isMovingLeft() == false) {
            moveRight();
        }
    }

    public void jump() {
        if (jump == false) {
            moveY = JUMPSPEED;
            jump = true;
        }
    }

    public void shoot() {
        GameCollision p;
        if (getDirection() == "right")
            p = new GameCollision(centerX-5, centerY-5,true);
        else
            p = new GameCollision(centerX-5, centerY-5,false);
	projectiles.add(p);
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public boolean isJumped() {
        return jump;
    }

    public int getmoveX() {
        return moveX;
    }

    public int getmoveY() {
        return moveY;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public void setJumped(boolean jumped) {
        this.jump = jumped;
    }

    public void setmoveX(int moveX) {
        this.moveX = moveX;
    }

    public void setmoveY(int moveY) {
        this.moveY = moveY;
    }

    public boolean isDucked() {
        return ducked;
    }

    public void setDucked(boolean ducked) {
        this.ducked = ducked;
    }

    public boolean isMovingRight() {
        return RightMove;
    }

    public void setMovingRight(boolean RightMove) {
        this.RightMove = RightMove;
    }

    public boolean isMovingLeft() {
        return LeftMove;
    }

    public void setMovingLeft(boolean LeftMove) {
        this.LeftMove = LeftMove;
    }

    public ArrayList getProjectiles() {
        return projectiles;
    }

    public static String getDirection(){
        return direction;
    }
}