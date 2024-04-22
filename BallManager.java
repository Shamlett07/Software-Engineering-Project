/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;

public class BallManager
{
    Shape bouncyBall;
    ArrayList <Shape> sub_shapes = new ArrayList<>();
    ArrayList <Shape> unsub_shapes = new ArrayList<>();;
    
    Object tableData[] = {0,0,0};
    
    private int currentWidth = 700; 
    private int currentHeight = 700;
    
    int id_nums = 0;
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
        bouncyBall.setID(id_nums);
        bouncyBall.setInitialPosition(currentWidth, currentHeight);
        bouncyBall.updateBoundaries(currentWidth, currentHeight);
        sub_shapes.add(bouncyBall);
        id_nums++;
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
                    for(int i = 0; i < unsub_shapes.size(); i++ )
                    {
                        if(unsub_shapes.get(i).getId() == id)
                        {
                            tableData[0] = unsub_shapes.get(i).getId();
                            tableData[1] = unsub_shapes.get(i).getSize();
                            tableData[2] = unsub_shapes.get(i).getSpeed();
                            sub_shapes.add(unsub_shapes.get(i));
                            unsub_shapes.remove(i);
                        }
                    }
                }
        return tableData;
        
        
    }
    public void setCurrentDimensions(int width, int height) {
        this.currentWidth = width;
        this.currentHeight = height;
        updateAllBoundaries(width, height);
}         
    public void updateAllBoundaries(int width, int height) {
        for (Shape shape : sub_shapes) {
            shape.updateBoundaries(width, height);
        }
    }

}    
   
