package aaaaa;
import java.awt.event.MouseEvent;

public class Control extends StaticBackground{
    
    public double xAxis =-20.5;  /* x-coordinate  */
    public double yAxis =-20.5;  /* y-coordinate */

    void mousePress(MouseEvent me) {
        int x = me.getX();
        int y = me.getY();
        
        if (x>62 && x<212 && y>352 && y<392){
            StartingClass.State = "guide"; 
        }
        else if(x>22 && x<172 && y>702 && y<742){
            StartingClass.State="menu";
        }
    }
}
