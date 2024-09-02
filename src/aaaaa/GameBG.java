package aaaaa;

public class GameBG {
	
	private int bX, bY, moveX;
	public GameBG(int x, int y){
		bX = x;
		bY = y;
		moveX = 0;
	}
	
	public void update() {
		bX += moveX;
		if (bX < -1920*3){
			bX=1920;
		}
        if (bX > 1920*2){
            bX = -1920*2;
        }
	}

	public int getBgX() {
		return bX;
	}

	public int getBgY() {
		return bY;
	}

	public int getmoveX() {
		return moveX;
	}

	public void setBgX(int bX) {
		this.bX = bX;
	}

	public void setBgY(int bY) {
		this.bY = bY;
	}

	public void setmoveX(int moveX) {
		this.moveX = moveX;
	}	
}