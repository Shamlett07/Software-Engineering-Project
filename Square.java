/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Staci Hamlett
 */
public class Square extends Shape
{
    
    public void moveShape(){
        //update direction
        if (x_pos + dx < 0 || x_pos + size + dx > x_boundary) {
            dx *= -1; //go to opposite direction (horizontal)
        }
        else if (y_pos + dy < 0 || y_pos + size + dy > y_boundary) {
            dy *= -1; //go to opposite direction (vertical)
        }
        
        //update position
        x_pos += dx;
        y_pos += dy;
    }
}
