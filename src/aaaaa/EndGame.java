package aaaaa;
import java.awt.event.MouseEvent;

public class EndGame extends StaticBackground{
    public double xAxis = -112; /* x-coordinate  */
    public double yAxis = -62; /* y-coordinate  */
    
    void mousePress(MouseEvent me) {
        int x  = me.getX();
        int y = me.getY();
        
        StartingClass.restart();
        
        if (x >62 && x <212 && y>352 && y<392){
            StartingClass.State = "menu";
        }
        else if(x >62 && x <212 && y>402 && y<442){
            StartingClass.State="game";
        }
    }
}