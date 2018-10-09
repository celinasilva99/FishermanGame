
        package game;


import city.cs.engine.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
/**
 * A MouseListener that drops a bowling ball on each mouse press.
 */
public class Hookmover implements MouseMotionListener{

    private WorldView view;
    int mx,my;
    Hook hook;
    
    public Hookmover(WorldView view, Hook hook) {
        this.view = view;
        this.hook = hook;
    }
    
    
   @Override
    public void mouseMoved(MouseEvent e) {
        hook.setPosition(view.viewToWorld(e.getPoint()));
     
    }

    @Override
    public void mouseDragged(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void mousePressed(MouseEvent e) {
        
        hook.setPosition(view.viewToWorld(e.getPoint()));
        hook.destroy();
        
    }
}

        
