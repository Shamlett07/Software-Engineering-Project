/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;

public class ControlForm extends JFrame
{
    BallObserver ball_observer;
    
    int win_height = 700;
    int win_width = 700;
    
    public ControlForm()
    {
        
        this.setTitle("Control Form");
        this.setSize(win_width, win_height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2,2));
        
        
        
        this.add(observer());
        this.add(ball_features());
        this.add(subject_observer());
        this.add(unsub_shapes());
        
        
        this.setVisible(true);
        
    }
    private JPanel observer(){
        
        JPanel observer = new JPanel();
        JLabel observer_label = new JLabel();
        observer_label.setText("Observers");
        observer.add(observer_label);
        return observer;
    }
    
    private JPanel subject_observer()
    {
        JPanel subjects = new JPanel();
        JLabel subject_label = new JLabel();
        subject_label.setText("Subjects of Observer");
        subjects.add(subject_label);
        
        return subjects;
    }
    private JPanel ball_features(){
        JPanel ball_features = new JPanel(new BorderLayout());
        JLabel ball_label = new JLabel();
        ball_label.setText("Ball Features");
        ball_features.add(ball_label,BorderLayout.NORTH);
        
        Box checkbox = Box.createVerticalBox();
        JCheckBox change_size = new JCheckBox();
        change_size.setText("Change Size");
        JCheckBox change_speed = new JCheckBox();
        change_speed.setText("Change speed");
        JCheckBox change_direction = new JCheckBox();
        change_direction.setText("Change direction");
        JCheckBox change_color = new JCheckBox();
        change_color.setText("Change Color");        
        
        checkbox.add(change_size);
        checkbox.add(change_speed);
        checkbox.add(change_direction);
        checkbox.add(change_color);
        
        Box shape_choice = Box.createVerticalBox();
        JRadioButton ball = new JRadioButton();
        ball.setText("Ball");
        JRadioButton triangle = new JRadioButton();
        triangle.setText("Triangle");
        JRadioButton square = new JRadioButton();
        square.setText("Square");
        
        shape_choice.add(ball);
        shape_choice.add(triangle);
        shape_choice.add(square);
        
        ball_features.add(shape_choice,BorderLayout.CENTER);
        ball_features.add(checkbox, BorderLayout.EAST);
        
        JButton create_shape = new JButton();
        create_shape.setText("Create A Shape");
        create_shape.setSize(20,20);
        
        ball_features.add(create_shape,BorderLayout.SOUTH);
        
        
        return ball_features;
    }
    
    private JPanel unsub_shapes(){
        JPanel unsub_shapes = new JPanel();
        JLabel unsub_label = new JLabel();
        unsub_label.setText("Shapes");
        unsub_shapes.add(unsub_label);
            
        return unsub_shapes;
    }
    
    public static void main(String[] args) {
        ControlForm controllerForm = new ControlForm();
    }
    
}
