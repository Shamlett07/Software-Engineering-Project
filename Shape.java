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
    static int id = 0;
    int x_boundary;
    int y_boundary;

    int size = 80;
    int speed = 20;
    Color color;
    int x_pos = 50;
    int y_pos = 50;
   
    int dx = 6; 
    int dy = 4;
   
    
    Timer timer;
    
    Shape(){
        id+=1;
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
        size = new_size;
    }
    void setSpeed(int new_speed)
    {
        speed = 100 - new_speed;
        
        if (timer != null) {
            timer.setDelay(speed); // Update the timer's delay to reflect the new speed
        }
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
    public int getId(){
        return id;
    }
    
}
