package aaaaa;
import java.awt.event.MouseEvent;

public class GameMenu extends StaticBackground{
    
    public double xAxis = -700; /* x-coordinate  */
    public double yAxis = -600; /* y-coordinate */
    public double printX=xAxis;
    public double printY=yAxis;

    void mousePress(MouseEvent me) {
        int x = me.getX();
        int y = me.getY();
        
        if (x>62 && x<212 && y>252 && y<292) //Play button
            StartingClass.State = "game";
        else if (x>62 && x<212 && y>352 && y<392) //guide button
            StartingClass.State = "guide";
        else if(x>62 && x<212 && y>452 && y<492)
            System.exit(1);   
    }
}