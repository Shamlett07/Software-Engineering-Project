/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;

public class Circle extends Shape {
    
    public void moveShape(Graphics g)
    {
        
        if(x_pos < x_boundary-size && y_pos < y_boundary-size)
        {
            x_pos += 20;
            y_pos += 20;
            System.out.println("New Circle \nX: "+x_pos+"\nY: "+y_pos);
        }
    }
    public void drawShape(Graphics g){
        
        g.fillOval(x_pos, y_pos, size, size);
    }
}
