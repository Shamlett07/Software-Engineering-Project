/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlForm extends JFrame
{
    BallObserver ball_observer;
    
    int win_height = 500;
    int win_width = 450;
    
    private JSlider speedSlider;
    private JComboBox<String> colorComboBox;
    private String[] colors = {"Red", "Black", "Blue", "Green"};
    private JSlider sizeSlider;
    
    ButtonGroup shapeButtonGroup = new ButtonGroup();
    private JRadioButton shape1;
    private JRadioButton shape2;
    private JRadioButton shape3;
    
    
    public ControlForm()
    {
        this.setTitle("Control Form");
        this.setSize(win_width, win_height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(5,1));
        
        this.add(shapeSelection());
        this.add(speedSelection());
        this.add(colorSelection());
        this.add(sizeSelection());
        this.add(addBallButton());
        
        this.setVisible(true);
        
    }
    
    //method to select shape
    private JPanel shapeSelection()
    {
        JPanel shapeLabel = new JPanel(new GridLayout(3, 1));
        
        shape1 = new JRadioButton("Circle");
        shapeButtonGroup.add(shape1);
        shape2 = new JRadioButton("Triangle");
        shapeButtonGroup.add(shape2);
        shape3 = new JRadioButton("Square");
        shapeButtonGroup.add(shape3);
        
        shapeLabel.add(shape1);
        shapeLabel.add(shape2);
        shapeLabel.add(shape3);
       
        shapeLabel = createLabeledPanel("Select Shape:", shapeLabel);
        return shapeLabel;
    }
    
    //method to select speed with a slider
    private JPanel speedSelection()
    {
        speedSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        speedSlider.setMajorTickSpacing(10);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);
        JPanel speedLabel = new JPanel();
        speedLabel = createLabeledPanel("Select Speed:", speedSlider);
        return speedLabel;
    }
    
    //method to select color
    private JPanel colorSelection()
    {
        colorComboBox = new JComboBox<>(colors);
        JPanel colorLabel = new JPanel();
        colorLabel = createLabeledPanel("Select Color:", colorComboBox);
        return colorLabel;
    }
    
    //method to select size with a slider
    private JPanel sizeSelection()
    {
        sizeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        sizeSlider.setMajorTickSpacing(10);
        sizeSlider.setPaintTicks(true);
        sizeSlider.setPaintLabels(true);
        JPanel sizeLabel = new JPanel();
        sizeLabel = createLabeledPanel("Select Size:", sizeSlider);
        return sizeLabel;
    }
    
    //method to add the "add ball" button
    private JPanel addBallButton()
    {
        JButton addBall = new JButton("Add Ball");
        addBall.setSize(20,20);
        JPanel addBallLabel = new JPanel();
        addBallLabel.add(addBall);
        
        //listener to print the configuration of the ball selected
        addBall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String selectedShape = "";
                if (shape1.isSelected()) {
                    selectedShape = "Circle";
                    } 
                    else if (shape2.isSelected()) {
                    selectedShape = "Triangle";
                    }
                    else if (shape3.isSelected()) {
                    selectedShape = "Square";
                   }
                if(selectedShape.isEmpty()){
                    JOptionPane.showMessageDialog(null, "There was No Shape Selected. Please Selected The Desired Shape");
                }
                else
                {
                    int selectedSpeed = speedSlider.getValue();
                    String selectedColor = (String) colorComboBox.getSelectedItem();
                    int selectedSize = sizeSlider.getValue();

                    System.out.println("Shape: " + selectedShape);
                    System.out.println("Speed: " + selectedSpeed);
                    System.out.println("Color: " + selectedColor);
                    System.out.println("Size: " + selectedSize);
                
                    //if ball observer null
                    // create the observer
                    //else add ball
                    if(ball_observer == null)
                    {
                        ball_observer = new BallObserver();
                    }
                   
                        
                    ball_observer.addBall(selectedShape, selectedColor);
                }
            }
        });
        
        return addBallLabel;
    }
    
    // helper method to create a panel with comment on left and selection on the right
    private JPanel createLabeledPanel(String labelText, JComponent component) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        panel.add(new JLabel(labelText), BorderLayout.WEST);
        panel.add(component, BorderLayout.CENTER);
        return panel;
    }
    
    public static void main(String[] args) {
        ControlForm controllerForm = new ControlForm();
    }
    
}
