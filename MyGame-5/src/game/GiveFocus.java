/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author cs
 */
public class GiveFocus extends MouseAdapter {
    private Component target;
    
    /**
     * Initialize the listener.
     * @param target the component to be given the focus on mouseEntered().
     */
    public GiveFocus(Component target) {
        this.target = target;
    }
    
    /**
     * Called when the mouse enters a component.
     * @param e description of the mouse event
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        target.requestFocus();
    }
}



