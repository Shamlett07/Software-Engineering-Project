/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class Shape extends JPanel
{
    int size_multiplier;
    int size = 100;
    int speed = 900;
    int direction;
    Color color;
    int x_pos = 50;
    int y_pos = 50;
    int x_boundary = 700;
    int y_boundary = 700;
    
    Timer timer;
    Shape(){
        /*  We need to be able to account for 
            the size of the shape so it doesn't appear out
            of bounds */ 
           
//        Random random = new Random();
//        x_pos = random.nextInt(500) + 50;
//        y_pos = random.nextInt(500) + 50;
    timer = new Timer (speed, new ActionListener()
        {
            @Override
           public void actionPerformed(ActionEvent ae)
           {
               repaint();
           } 
        });
        timer.start();
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(color);
        drawShape(g);
        moveShape(g);
    }
    public abstract void drawShape(Graphics g);
    public abstract void moveShape(Graphics g);
    
    void setSize(int new_size)
    {
        size_multiplier = new_size;
    }
    void setSpeed(int new_speed)
    {
        speed = new_speed;
    }
    
    public void setColor(String new_color)
    {
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
