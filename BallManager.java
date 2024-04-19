/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.bouncingballproject;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BallManager
{
    ArrayList<Shape> balls = new ArrayList<>();
    JPanel managerPane = new JPanel();
    String  unsub_shapes[][];
    Object sub_shapes[] = {0 ,0 ,0 ,0};

    String cols [] = {"Id", "Size", "Speed"};

    private JTable subTable;
    private JTable unsubTable;
    private JScrollPane sp_sub;
    private JScrollPane sp_unsub;
    
    DefaultTableModel model = new DefaultTableModel(0,cols.length);
    DefaultTableModel unsub_model = new DefaultTableModel(0,cols.length);
    
    public BallManager()
    {
        model.setColumnIdentifiers(cols);
        unsub_model.setColumnIdentifiers(cols);
        subTable = new JTable(model);
        sp_sub = new JScrollPane(subTable);
        
        managerPane.setLayout(new GridLayout(1,3));
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
        
        rightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = subTable.getSelectedRow();
                if (selectedRow != -1) {
                    Object[] rowData = new Object[3];
                    rowData[0] = model.getValueAt(selectedRow, 0);
                    rowData[1] = model.getValueAt(selectedRow, 1);
                    rowData[2] = model.getValueAt(selectedRow, 2);
                    unsub_model.addRow(rowData);
                    model.removeRow(selectedRow);
                }
                else {
                    JOptionPane.showMessageDialog(managerPane, "Please select the shape you would like to move.", "No Shape Selected", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        leftButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = unsubTable.getSelectedRow();
                if (selectedRow != -1) {
                    Object[] rowData = new Object[3];
                    rowData[0] = unsub_model.getValueAt(selectedRow, 0);
                    rowData[1] = unsub_model.getValueAt(selectedRow, 1);
                    rowData[2] = unsub_model.getValueAt(selectedRow, 2);
                    model.addRow(rowData);
                    unsub_model.removeRow(selectedRow);
                }
            }
        });

        middlePanel.add(rightButton);
        middlePanel.add(leftButton);

        JPanel lastPanel = new JPanel();
        lastPanel.setLayout(new BorderLayout());

        unsubTable = new JTable(unsub_model);
        sp_unsub = new JScrollPane(unsubTable);
        lastPanel.add(new JLabel("Unsubscribed Shapes"), BorderLayout.NORTH);
        lastPanel.add(sp_unsub, BorderLayout.CENTER);
        
        managerPane.add(subPanel);
        managerPane.add(middlePanel);
        managerPane.add(lastPanel);
        //managerPane.setBounds(100,100,100,100);
    }
    public JPanel getPanel(){
        return managerPane;
    }
    public void addToTable(int id,int size, int speed){
        sub_shapes[0] = id;
        sub_shapes[1] = size;
        sub_shapes[2] = speed;
         model.addRow(sub_shapes);
    }
    
   
}    
   
