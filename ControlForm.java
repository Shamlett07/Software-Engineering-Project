/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class ControlForm extends JFrame
{
    BallObserver ball_observer;
    BallManager ball_manager = new BallManager();
    
    int win_height = 500;
    int win_width = 500;
    
    private JSlider speedSlider;
    private JComboBox<String> colorComboBox;
    private String[] colors = {"Red", "Black", "Blue", "Green"};
    private JSlider sizeSlider;
    
    ButtonGroup shapeButtonGroup = new ButtonGroup();
    private JRadioButton shape1;
    private JRadioButton shape2;
    private JRadioButton shape3;
    
    int selectedSpeed;
    String selectedColor;
    int selectedSize;
    JPanel manageButtons = new JPanel();
    
    private boolean ballOpen = false;
    String  unsub_shapes[][];
    Object sub_shapes[] = {0 ,0 ,0};

    String cols [] = {"Id", "Size", "Speed"};

    private JTable subTable;
    private JTable unsubTable;
    private JScrollPane sp_sub;
    private JScrollPane sp_unsub;
    DefaultTableModel sub_model = new DefaultTableModel(0,cols.length);
    DefaultTableModel unsub_model = new DefaultTableModel(0,cols.length);
    
    public ControlForm()
    {
        this.setTitle("Control Form");
        this.setSize(win_width, win_height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(6, 2));
        this.add(shapeSelection());
        this.add(speedSelection());
        this.add(colorSelection());
        this.add(sizeSelection());
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,1));

        this.add(ManagerButtons());
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
                } else if (shape2.isSelected()) {
                    selectedShape = "Triangle";
                } else if (shape3.isSelected()) {
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
                    ball_manager.subShape(selectedShape, selectedColor, selectedSize, selectedSpeed);
                    subscribeBall();
                                        
                    if (!ballOpen){
                        ball_observer = new BallObserver(ball_manager);
                        ballOpen = true;
                    }
                    ball_observer.addBallToObserver();
                }
                
            }
        });
        
        return addBallLabel;
    }
    
    private JPanel createLabeledPanel(String labelText, JComponent component) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        panel.add(new JLabel(labelText), BorderLayout.WEST);
        panel.add(component, BorderLayout.CENTER);
        return panel;
    }
    
    private JPanel ManagerButtons(){

        JPanel managerPanel = new JPanel();
        sub_model.setColumnIdentifiers(cols);
        unsub_model.setColumnIdentifiers(cols);
        subTable = new JTable(sub_model);


        sp_sub = new JScrollPane(subTable);
        managerPanel.setLayout(new GridLayout(1,3));
        //sub table
        JPanel subPanel = new JPanel();
        subPanel.setLayout(new BorderLayout());
        subPanel.add(new JLabel("Subscribed Shapes"), BorderLayout.NORTH);
        subPanel.add(sp_sub, BorderLayout.CENTER);

        //middle
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new GridLayout(2,1));
        JButton rightButton = new JButton(">");
        JButton leftButton = new JButton("<");

        middlePanel.add(rightButton);
        middlePanel.add(leftButton);

        rightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(subTable.getSelectionModel().isSelectionEmpty() != true){
                    
                    unsub_model.addRow(ball_manager.removeFromTable((int)subTable.getValueAt(subTable.getSelectedRow(), 0),"unsub") );
                    sub_model.removeRow(subTable.getSelectedRow());
                    

                } else {
                    JOptionPane.showMessageDialog(managerPanel,"Please select the shape you would like to move.", "No Shape Selected", JOptionPane.WARNING_MESSAGE);
                }
                }});
        leftButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(unsubTable.getSelectionModel().isSelectionEmpty() != true)
                {
                    sub_model.addRow(ball_manager.removeFromTable((int) unsubTable.getValueAt(unsubTable.getSelectedRow(), 0), "sub"));
                    unsub_model.removeRow(unsubTable.getSelectedRow());
                }
                else {
                    JOptionPane.showMessageDialog(managerPanel,"Please select the shape you would like to move.", "No Shape Selected", JOptionPane.WARNING_MESSAGE);
                }
                }});

        JPanel lastPanel = new JPanel();
        lastPanel.setLayout(new BorderLayout());

        unsubTable = new JTable(unsub_model);
        sp_unsub = new JScrollPane(unsubTable);
        lastPanel.add(new JLabel("UnSubscribed Shapes"), BorderLayout.NORTH);
        lastPanel.add(sp_unsub, BorderLayout.CENTER);
        managerPanel.add(subPanel);
        managerPanel.add(middlePanel);
        managerPanel.add(lastPanel);

        return managerPanel;
    }

    public void subscribeBall(){
        sub_model.addRow(ball_manager.addToTable());
    }
    
    public static void main(String[] args) {
        ControlForm controllerForm = new ControlForm();
    }
}