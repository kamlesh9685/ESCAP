package aaaaa;

import java.awt.Image;
import java.awt.Rectangle;

public class Bricks {
    
    private int brickX, brickY, moveX, pattern;
    public Image brickImage;
    private Avatar avatar = StartingClass.getavatar();
    private GameBG b = StartingClass.getBg1();
    private Rectangle rec;

    public Bricks(int x, int y, int patternint){
        brickX = x*40;
        brickY = y*40;
        pattern = patternint;
        rec = new Rectangle();    
        if (pattern == 2)
            brickImage = StartingClass.grasstop; 
        else if (pattern == 3)
            brickImage = StartingClass.brickdirt;
        else if (pattern == 4)
            brickImage = StartingClass.brickstone;
        else if (pattern == 6)
            brickImage = StartingClass.brickrock;
        else {
            pattern = 0;
        }
    }
    public void update(){
        moveX = b.getmoveX()*5;
        brickX += moveX;  
        rec.setBounds(brickX, brickY, 40, 40);
        
        if (rec.intersects(Avatar.redyellow) && pattern != 0) {                    
				checkVerticalCollision(Avatar.rec1, Avatar.rec2);
				checkSideCollision(Avatar.leftFoot, Avatar.rightFoot);
			}
        for (Obstacles i: Obstacles.enemy){
                if(rec.intersects(i.r)  && ( pattern == 2 || pattern == 3 || pattern == 6 )){
                        i.setmoveX(0);
                        if (i.getCenterX()<brickX)
                            i.setCenterX(brickX-55);
                        else if (i.getCenterX()>brickX)
                            i.setCenterX(brickX+56);
                    }
            }
    }
    
   public int getbrickX() {
        return brickX;
    }

    public void setbrickX(int brickX) {
        this.brickX = brickX;
    }

    public int getbrickY() {
        return brickY;
    }

    public void setbrickY(int brickY) {
        this.brickY = brickY;
    }
    public Rectangle getRectangle(){
        return rec;
    }
    public int getpattern(){
        return pattern;
    }

    public Image getbrickImage() {
        return brickImage;
    }

    public void setbrickImage(Image brickImage) {
        this.brickImage = brickImage;
    }
    
    public void checkVerticalCollision(Rectangle rtop, Rectangle rbot) {
        if (pattern == 2 || pattern == 3 || pattern == 6){
            if (rtop.intersects(rec)) {
                avatar.setCenterY(brickY+100);
                avatar.setmoveY(-avatar.JUMPSPEED);
            }

            if (rbot.intersects(rec)){
                avatar.setJumped(false);
                avatar.setmoveY(0);
                avatar.setCenterY(brickY - 75);
            }
        }
    }
    
     public void checkSideCollision(Rectangle leftfoot, Rectangle rightfoot) {
        if (pattern == 2 || pattern == 3 || pattern == 6 ){
            
           if (leftfoot.intersects(rec)) {
                avatar.setCenterX(brickX + 100);
                avatar.setmoveX(0);
            }
            
            else if (rightfoot.intersects(rec)) {
                avatar.setCenterX(brickX + 15);
                avatar.setmoveX(0);
            }
        }
    }
}