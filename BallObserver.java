
import java.awt.GridLayout;
import javax.swing.*;


public class BallObserver extends JFrame
{
    BouncyBall ball;
    int observer_width = 700;
    int observer_height = 700;
    JPanel show_shape = new JPanel();
    
    public BallObserver(String shape){
        
        this.setTitle("Observer");
        this.setSize(observer_width, observer_height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ball = new BouncyBall(shape);
        
        this.add(ball);
        
        this.setVisible(true);
        
    }
    
}
