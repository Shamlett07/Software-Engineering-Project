/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.mycompany.bouncingballproject;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class BallObserver extends JPanel {
    BallManager ball_manager;
    Timer timer;
    int speed = 10;
    Shape bouncyBall;
    JFrame observer = new JFrame();
    int observer_width = 700;
    int observer_height = 700;
    
    
    public BallObserver(BallManager ballManager){
        observer.setTitle("Observer");
        observer.setSize(observer_width, observer_height);
        observer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        observer.add(this);
        
        ball_manager = ballManager;
       
        addBallToObserver();
        
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = getWidth();
                int height = getHeight();
                for (Shape shape : ball_manager.sub_shapes) {
                    shape.updateBoundaries(width, height);
                }
            }
        });
        
        timer = new Timer (speed, new ActionListener()
        {
            @Override
           public void actionPerformed(ActionEvent ae)
           {
               for (int dex = 0; dex < ball_manager.sub_shapes.size(); dex++)
                {
                    movement(ball_manager.sub_shapes.get(dex));
                }

               repaint();
           } 
        });
        timer.start();
        observer.setLocationRelativeTo(null);
        observer.setVisible(true);
    }   
    
public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        shapeMovement(g);
    }
    public void shapeMovement(Graphics g){
        
        for (int dex = 0; dex < ball_manager.sub_shapes.size(); dex++)
        {
            bouncyBall = ball_manager.sub_shapes.get(dex);
            g.setColor(bouncyBall.color);
            if(ball_manager.sub_shapes.get(dex) instanceof Circle){

                g.fillOval(bouncyBall.x_pos, bouncyBall.y_pos, bouncyBall.size, bouncyBall.size);
            }
            else if (ball_manager.sub_shapes.get(dex) instanceof Square){
                g.fillRect(bouncyBall.x_pos, bouncyBall.y_pos, bouncyBall.size, bouncyBall.size);
            }
            else{
                g.fillPolygon(ball_manager.sub_shapes.get(dex).triangle_x_points,ball_manager.sub_shapes.get(dex).triangle_y_points , bouncyBall.num_of_points);
            }
        }
    }
    public void addBallToObserver(){
        for (int dex = 0; dex < ball_manager.sub_shapes.size(); dex++)
        {
            bouncyBall = ball_manager.sub_shapes.get(dex);
            ball_manager.updateAllBoundaries(getWidth(), getHeight());
            repaint();

        }
    }
    public void movement(Shape ball)
    {
        ball.moveShape();
    }
    public void updateObserverDimensions() {
        int width = getWidth();
        int height = getHeight();
        ball_manager.setCurrentDimensions(width, height);
    }
    
}