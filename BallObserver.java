/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Staci Hamlett
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class BallObserver extends JPanel {
    BallManager ball_manager;
    Timer timer;
    int speed = 10;
    Shape bouncyBall;
    JFrame observer = new JFrame();
    
    
    int observer_width = 700;
    int observer_height = 700;
    
    public BallObserver(BallManager ballManager)
    {
        observer.setTitle("Observer");
        observer.setSize(observer_width, observer_height);
        observer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        observer.add(this);
        
        ball_manager = ballManager;

        addBallToObserver();
        
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
            
        }
    }
    public void movement(Shape ball)
    {
        ball.moveShape();
    }

}
