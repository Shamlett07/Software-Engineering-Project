/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bouncingballproject;

import java.awt.*;
import javax.swing.*;
import java.util.*;


public class BouncyBall extends JPanel{
    String shape;
    static int[] triangle_x_points;
    static int[] triangle_y_points;
    static int num_of_points = 3;
    int size;
    int speed;
    int direction;
    Color color;

    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        drawShape(g);
    }
    void drawShape(Graphics g){
        g.setColor(color);
        switch (shape) {
            case "Triangle":
                drawTriangle(g);
                break;
            case "Square":
                drawSquare(g);
                break;
            case "Circle":
                drawCircle(g);
                break;
        }
    }
    
    private static void drawTriangle(Graphics g) {
        Random random = new Random();
        int size = 100;
        int height = (int) (size * Math.sqrt(3) / 2); 

        // Calculate the coordinates of the vertices
        int x1 = random.nextInt(600) + 50; // Random x-coordinate for the first vertex
        int y1 = random.nextInt(600) + 50; // Random y-coordinate for the first vertex
        int x2 = x1 + size / 2; // Second vertex is to the right of the first vertex
        int y2 = y1 + height; // Y-coordinate of the second vertex
        int x3 = x1 - size / 2; // Third vertex is to the left of the first vertex
        int y3 = y1 + height; // Y-coordinate of the third vertex

        // Define the arrays for x and y coordinates of the vertices
        int[] triangle_x_points = {x1, x2, x3};
        int[] triangle_y_points = {y1, y2, y3};
        
        g.fillPolygon(triangle_x_points, triangle_y_points, num_of_points);
    }

    private void drawSquare(Graphics g) {
        Random random = new Random();
        int x = random.nextInt(600) + 50;
        int y = random.nextInt(600) + 50;
        int size = 100;

        g.fillRect(x, y, size, size);
    }

    private static void drawCircle(Graphics g) {
        Random random = new Random();
        int x = random.nextInt(600) + 50;
        int y = random.nextInt(600) + 50;
        int diameter = 100;

        g.fillOval(x, y, diameter, diameter);
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