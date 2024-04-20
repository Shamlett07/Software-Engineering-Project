
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Staci Hamlett
 */
import java.util.*;
public class BallManager
{
    Shape bouncyBall;
    ArrayList <Shape> sub_shapes = new ArrayList<>();
    ArrayList <Shape> unsub_shapes = new ArrayList<>();
    
    Object tableData[] = {0,0,0};
    
    public void subShape(String shape, String color,int size, int speed)
    {
            switch (shape) {
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
        bouncyBall.setColor(color);
        bouncyBall.setSize(size);
        bouncyBall.setSpeed(speed);
        
        sub_shapes.add(bouncyBall);
        
          
    }

    public Object[] addToTable()
    {
        for(int dex = 0; dex < sub_shapes.size(); dex++ )
        {
            tableData[0] = sub_shapes.get(dex).getId();
            tableData[1] = sub_shapes.get(dex).getSize();
            tableData[2] = sub_shapes.get(dex).getSpeed();
            
        }
        return tableData;
    }
    public Object[] removeFromTable(int id, String method){
        if (method.equals("unsub")){
            for(int dex = 0; dex < sub_shapes.size(); dex++ )
            {
                if(sub_shapes.get(dex).getId() == id)
                {
                    tableData[0] = sub_shapes.get(dex).getId();
                    tableData[1] = sub_shapes.get(dex).getSize();
                    tableData[2] = sub_shapes.get(dex).getSpeed();
                    unsub_shapes.add(sub_shapes.get(dex));
                    sub_shapes.remove(dex);

                }
            }
        }
        else
        {
            for(int dex = 0; dex < unsub_shapes.size(); dex++ )
            {
                if(unsub_shapes.get(dex).getId() == id)
                {
                    tableData[0] = unsub_shapes.get(dex).getId();
                    tableData[1] = unsub_shapes.get(dex).getSize();
                    tableData[2] = unsub_shapes.get(dex).getSpeed();
                    sub_shapes.add(unsub_shapes.get(dex));
                    unsub_shapes.remove(dex);
                }
            }
        }
        
        return tableData;
    }

}

