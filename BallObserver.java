/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    public void addBall(String chosen_shape,String chosen_color)
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
        
        bouncyBall.setColor(chosen_color);
        this.add(bouncyBall);
    }
    
}