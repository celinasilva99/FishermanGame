/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.UserView;
import city.cs.engine.World;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *  Background.java - displays the background image in the world and displays the score. 
 * @author  Celina silva
 */
public class Background extends UserView{
    /**  
    *the horizontal width of the background image
*/ 
    private int x;
/**  
    * the vertical width of the background image
*/ 
    private int y;
   /**  
    *  An object Image of type Image
*/ 
    Image image;
    /**  
    * An object hook of type Hook
*/ 
    Hook hook;
    LevelOne one;
   
/**
   * Creates a Background in the world with the given player and size.
   *  @param world the world in which this Image exists.
   * the size includes vertical and horizontal.
   * the player should be the hook
   * this is the constructor
   */
    public Background(GameLevel world,Hook hook,int x,int y,Image image){
        super(world,x,y);
        this.image = new ImageIcon("data/background.jpg").getImage();
        this.hook = hook;
        
    }
    /**
    * @param g A variable of type Graphics2D
    *  Draws an image
    * */
    @Override
    protected void paintBackground(Graphics2D g){
        g.drawImage(image, 0,0, this);
    }
    /**
     * Draws score
     * <p>
     
    * @param g A variable of type Graphics2D
    * */
    public void paintForeground(Graphics2D g){
        Font myFont = new Font("Serif", Font.BOLD| Font.BOLD, 12);
        /**
         * 
         */
        g.drawString("Score:" + hook.getFishCount(), 80, 80);
        g.drawString("lives Remaining:" + hook.getliveCount(),600,80);
      
    }
   /**
 * Gets the {@link Hook} instance representing player.
 *The {@link String} instance representing something.
 */
    public void setPlayer(Hook hook)
            
    {
        this.hook = hook;
    }
    
    
}
