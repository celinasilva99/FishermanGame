/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.UserView;
import city.cs.engine.World;
import java.awt.Graphics2D;

/**
 *
 * @author cs
 */

    public class Score extends UserView {
    
    private Game game;
        
    public Score(World world, Game game, int width, int height) {
        super(world, width, height);
        this.game = game;
    }
    
    @Override
    protected void paintForeground(Graphics2D g) {
        g.drawString("Score: " + game.getPlayer().getFishCount(), 10, 20);
    }
}

