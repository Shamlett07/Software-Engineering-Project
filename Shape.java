/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Staci Hamlett
 */
import java.awt.*;
import java.util.*;
public abstract class Shape
{
    static int id = 0;
    int x_boundary = 700;
    int y_boundary = 700;
    
    protected int size = 80;
    protected int speed = 20;
    protected Color color;
    protected int x_pos;
    protected int y_pos;
   
    protected int dx = 6; 
    protected int dy = 4;
    int[] triangle_x_points = {0,0,0};
    int[] triangle_y_points = {0,0,0};
    int num_of_points = 3;
    Random ran = new Random();
    Shape(){
        id+=1;
        x_pos = ran.nextInt(500);
        y_pos = ran.nextInt(500);
    }
    
    public abstract void moveShape();
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
    public void setSize(int new_size)
    {
        size = new_size;
    }
    public void setSpeed(int new_size){
        speed = new_size;
    }
    
    public int getId(){
        return id;
    }
    public Color getColor(){
        return color;
    }
    public int getSize(){
        return size;
    }
    public int getSpeed(){
        return speed;
    }
}

