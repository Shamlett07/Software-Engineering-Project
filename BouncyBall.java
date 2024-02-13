/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.event.*;

public class BouncyBall {
    int size;
    int speed;
    int direction;
    String shape;
    Color[] color = {Color.RED,Color.BLACK,Color.BLUE,Color.CYAN};
    
    
    void setSize(int new_size){
        size = new_size;
    }
    void setSpeed(int new_speed){
        speed = new_speed;
    }
    void setShape(String new_shape){
        shape = new_shape;
    }
}
