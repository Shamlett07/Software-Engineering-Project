/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.mycompany.bouncingballproject;


import java.awt.Insets;
import javax.swing.*;
public class BallObserver extends JFrame
{
    Shape bouncyBall;
    int observer_width = 700;
    int observer_height = 700;
    
    
    public BallObserver(){
        this.setTitle("Observer");
        this.setSize(observer_width, observer_height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
    }   
    public void addBall(String chosen_shape, String chosen_color, int chosen_size, int chosen_speed)
    {
        switch (chosen_shape) {
            case "Triangle":
                bouncyBall = new Triangle();
                break;
            case "Square":
                bouncyBall = new Square();
                break;
            case "Circle":
                bouncyBall = new Circle();
                break;
        }
        
        Insets insets = getInsets();
        bouncyBall.x_boundary = observer_width;
        bouncyBall.y_boundary = observer_height - insets.bottom - insets.top;
        
        bouncyBall.setSize(chosen_size);
        bouncyBall.setColor(chosen_color);
        bouncyBall.setSpeed(chosen_speed);
        this.add(bouncyBall);
        this.validate();
        this.repaint();
    }
    
}