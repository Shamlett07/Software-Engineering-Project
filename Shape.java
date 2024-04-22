/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.*;
import java.util.*;
public abstract class Shape
{
    private int id;
    protected int x_boundary = 700;
    protected int y_boundary = 700;

    protected int size = 60;
    protected int speed = 20;
    protected Color color;
    protected int x_pos = 100;
    protected int y_pos = 100;

    protected int dx = 6; 
    protected int dy = 4;
    int[] triangle_x_points = {0,0,0};
    int[] triangle_y_points = {0,0,0};
    int num_of_points = 3;
    Random ran = new Random();
    
    Shape(){
        
    }
    public void setInitialPosition(int maxWidth, int maxHeight) {
        this.x_pos = ran.nextInt(maxWidth - size) + 1;
        this.y_pos = ran.nextInt(maxHeight - size)+ 1;
        System.out.println("Max Width: "+maxWidth+" Max Height: "+maxHeight);
        System.out.println("Spawn at "+x_pos+", "+ y_pos);
    }
    
    public void updateBoundaries(int width, int height) {
        this.x_boundary = width;
        this.y_boundary = height;
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
    public void setSpeed(int new_speed){
        speed = new_speed;
    }
    
    public void setXbound(int new_xbound){
        x_boundary = new_xbound;
    }
    public void setYbound(int new_ybound){
        y_boundary = new_ybound;
    }
    public void setID(int new_id){
        id = new_id;
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