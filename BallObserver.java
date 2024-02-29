
import javax.swing.*;
import java.util.*;


public class BallObserver extends JFrame
{
    BouncyBall ball = new BouncyBall();
    int observer_width = 700;
    int observer_height = 700;
    
    public BallObserver(){
        
        this.setTitle("Observer");
        this.setSize(observer_width, observer_height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
           
    }
    public void addBall(String shape,String color)
    {
        ball.shape = shape;
        ball.setColor(color);
        this.add(ball);
        
    }
    
}
