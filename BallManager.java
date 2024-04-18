/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.bouncingballproject;

import javax.swing.*;
import java.awt.event.*;

public class BallManager extends JFrame
{
    BallObserver observer;
    
    public BallManager(BallObserver observer)
    {
        this.observer = observer;
        
    }
    public void addBall(String shape, String color, int size, int speed) {
        observer.addBall(shape, color, size, speed);
    }
}    
   
