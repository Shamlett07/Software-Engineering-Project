
import java.awt.Graphics;


public class Square extends Shape
{
    
    public void moveShape(Graphics g){
    }
    public void drawShape(Graphics g)
    {
        g.fillRect(x_pos, y_pos, size, size);
    }
}
