/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



public class Circle extends Shape {
    
    public void moveShape() {
        x_pos += dx * (speed / 45);
        y_pos += dy * (speed / 45);
        //update direction
        if (x_pos + dx < 0 || x_pos + size + dx > x_boundary) {
            dx *= -1; //go to opposite direction (horizontal)
        }
        if (y_pos + dy < 0 || y_pos + size + dy > y_boundary) {
            dy *= -1; //go to opposite direction (vertical)
        }
        
        //update position
        x_pos += dx;
        y_pos += dy;
    }

}