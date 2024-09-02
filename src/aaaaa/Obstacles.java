package aaaaa;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Obstacles {

	private int maxHealth, currentHealth, power, moveX, centerX, centerY;
	private GameBG bg = StartingClass.getBg1();
        public Rectangle r = new Rectangle(0,0,0,0);
        public int health = 5;
        private boolean isdead;
        public static ArrayList<Obstacles> enemy = new ArrayList<Obstacles>();
        private int movementSpeed;
        public String direction = "left";
        
        public Obstacles(int centerX, int centerY) {
		setCenterX(centerX);
		setCenterY(centerY);
	}
        
	// Behavioral Methods
	public static void update() {
            
            for (Obstacles i: enemy) {
                    i.follow();
                    i.centerX += i.moveX;
                    i.moveX = i.bg.getmoveX() * 5 + i.movementSpeed;
                    i.r.setBounds(i.centerX - 30, i.centerY-10, 85, 60);

                    if (i.r.intersects(Avatar.redyellow))
                            i.checkCollision();
            }
	}
        
    public void follow() {
                if (centerX - StartingClass.getavatar().getCenterX() >650){
                    this.movementSpeed = 0;
                }
                else if (StartingClass.getavatar().getCenterX() - centerX > 650){
                    this.movementSpeed = 0;
                }

		else if (Math.abs(StartingClass.getavatar().getCenterX() - centerX) < 5) {
			this.movementSpeed = 0;
		}

		else {
			if (StartingClass.getavatar().getCenterX() >= centerX) {
				this.direction = "right";
                this.movementSpeed = 2;
			} 
            else {
                this.direction = "left";
				this.movementSpeed = -2;
			}
		}

	}
    private void checkCollision(){
		if (r.intersects(Avatar.rec1) || r.intersects(Avatar.rec2)){
			StartingClass.State = "dead";
			}
        }

	public void attack() {

	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public int getPower() {
		return power;
	}

	public int getmoveX() {
		return moveX;
	}

	public int getCenterX() {
		return centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public GameBG getBg() {
		return bg;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setmoveX(int moveX) {
		this.moveX = moveX;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public void setBg(GameBG bg) {
		this.bg = bg;
	}
        public boolean getIsDead(){
            return isdead;
        }
        public void setIsDead(boolean s){
            isdead = s;
        }	
}