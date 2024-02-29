/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.mycompany.bouncingballproject;


import javax.swing.*;
import java.util.*;


public class BallObserver extends JFrame
{
    BouncyBall ball = new BouncyBall();
    int observer_width = 700;
    int observer_height = 700;
    
    public BallObserver(){
        
        this.setTitle("Observer");
        this.setSize(observer_width, observer_height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void addBall(String shape,String color)
    {
        ball.shape = shape;
        ball.setColor(color);
        this.add(ball);
        this.revalidate();
        this.repaint();
        
    }
    
}