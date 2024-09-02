package aaaaa;

import java.awt.Rectangle;
import java.util.ArrayList;

public class GameCollision {

	private int x, y, moveX;
	private boolean visual;
    private Rectangle rec;
        
	public GameCollision(int startX, int startY, boolean right){
		x = startX;
		y = startY;
                if (right)
                    moveX =30;
                else
                    moveX = -30;
		visual = true;
        rec = new Rectangle(0, 0, 0, 0);
	}
	
	public void update(){
		x += moveX;
        rec.setBounds(x, y, 10, 5);
		if (x > 1366 || x<0){
			visual = false;
                        rec = null;
		}
        else
            checkCollision();                
		
	}
        private void checkCollision() {
            ArrayList bricks = StartingClass.getbrickArray();
			for (int i = 0; i < bricks.size(); i++) {
				Bricks p = (Bricks) bricks.get(i);
                        if (rec != null){
                            if (rec.intersects(p.getRectangle()) && (p.getpattern()==2||p.getpattern()==3||p.getpattern()==6)){
                                if (Avatar.getDirection() == "right")
                                    x = p.getbrickX()-35;    
                                else if (Avatar.getDirection() == "left")
                                    x = p.getbrickX()+50;
                                visual = false;
                            }
                        } 
                }
            for (Obstacles i: Obstacles.enemy){
                if(rec.intersects(i.r)){
                    visual = false;
                    if (i.health > 0) {
                        i.health -= 1;
                    }
                    if (i.health == 0) {
                        i.setIsDead(true);
                    }
                    }
            }
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getmoveX() {
		return moveX;
	}

	public boolean isvisual() {
		return visual;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setmoveX(int moveX) {
		this.moveX = moveX;
	}

	public void setVisible(boolean visual) {
		this.visual = visual;
	}	
}