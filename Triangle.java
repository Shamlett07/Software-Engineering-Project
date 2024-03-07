/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.bouncingballproject;

import java.awt.Graphics;

public class Triangle extends Shape 
{
    int num_of_points = 3;

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
        int height = (int) (size * Math.sqrt(3) / 2); 

        // Calculate the coordinates of the vertices
        int x1 = x_pos; // Random x-coordinate for the first vertex
        int y1 = y_pos; // Random y-coordinate for the first vertex
        int x2 = x1 + size / 2; // Second vertex is to the right of the first vertex
        int y2 = y1 + height; // Y-coordinate of the second vertex
        int x3 = x1 - size / 2; // Third vertex is to the left of the first vertex
        int y3 = y1 + height; // Y-coordinate of the third vertex

        // Define the arrays for x and y coordinates of the vertices
        int[] triangle_x_points = {x1, x2, x3};
        int[] triangle_y_points = {y1, y2, y3};
        
        g.fillPolygon(triangle_x_points, triangle_y_points, num_of_points);
        
    }
}