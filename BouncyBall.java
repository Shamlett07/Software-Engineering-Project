/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import javax.swing.*;

public class BouncyBall extends JPanel
{
    String shape;
    int[] triangle_x_points = {105,60,150};
    int[] triangle_y_points = {100,200,200};
    int num_of_points = 3;
    int size;
    int speed;
    int direction;
    Color color;

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        drawShape(g);
        repaint();
    }
    void drawShape(Graphics g){
        g.setColor(color);
        switch (shape) 
        {
            case "Triangle":
                g.fillPolygon(triangle_x_points, triangle_y_points, num_of_points);
                break;
            case "Square":
                g.fillRect(200, 200, 100, 100);
                break;
            case "Circle":
                g.fillOval(100, 100, 100, 100);
                break;
        }
       
        
    }
    void setSize(int new_size){
        size = new_size;
    }
    void setSpeed(int new_speed){
        speed = new_speed;
    }
    void setColor(String new_color){
        switch (new_color){
            case "Red":
                color = Color.RED;
                break;
            case "Black":
                color = Color.BLACK;
                break;
            case "Blue":
                color = Color.BLUE;
                break;
            case "Green":
                color = Color.GREEN;
                break;
        }
    }
}
