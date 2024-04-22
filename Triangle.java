/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Triangle extends Shape 
{
    

    // Calculate the coordinates of the vertices
    int x1; // Random x-coordinate for the first vertex
    int y1; // Random y-coordinate for the first vertex
    int x2; // Second vertex is to the right of the first vertex
    int y2; // Y-coordinate of the second vertex
    int x3; // Third vertex is to the left of the first vertex
    int y3; // Y-coordinate of the third vertex


    public void moveShape()
    {
        
        setThePoints();
        //update direction
        if (x3 + dx < 0 || x2 + dx > x_boundary) {
            dx *= -1; //go to opposite direction (horizontal)
        }
        if (y1 + dy < 0 || y2 + dy > y_boundary) {
            dy *= -1; //go to opposite direction (vertical)
        }
        
        x_pos += dx * (speed / 45);
        y_pos += dy * (speed / 45);
        //update position
        x1 += dx;
        x2 += dx;
        x3 += dx;
        y1 += dy;
        y2 += dy;
        y3 += dy;
        
        triangle_y_points[0] = y1;
        triangle_y_points[1] = y2;
        triangle_y_points[2] = y3;

        triangle_x_points[0] = x1;
        triangle_x_points[1] = x2;
        triangle_x_points[2] = x3;
       
    }
    public void setThePoints()
    {
        int height = (int) (size * Math.sqrt(3) / 2);     
        x1 = x_pos; // Randint height = (int) (size * Math.sqrt(3) / 2); om x-coordinate for the first vertex
        y1 = y_pos; // Random y-coordinate for the first vertex
        x2 = x1 + size / 2; // Second vertex is to the right of the first vertex
        y2 = y1 + height; // Y-coordinate of the second vertex
        x3 = x1 - size / 2; // Third vertex is to the left of the first vertex
        y3 = y1 + height; // Y-coordinate of the third vertex
    }
}