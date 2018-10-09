/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.World;
import java.awt.Graphics2D;
import javax.swing.JLabel;
import static javax.swing.SpringLayout.HEIGHT;
import static javax.swing.SpringLayout.WIDTH;
import org.jbox2d.common.Vec2;

/**
 *
 * @author cs
 */
public abstract class GameLevel extends World {

    private Hook player;

    public Hook getPlayer() {
        return player;
    }

    /**
     * Populate the world of this level. Child classes should this method with
     * additional bodies.
     */
    public void populate(Game game) {

//        Shark skark = new Shark();
        //player = new MainFish((World)this);
        player = new Hook((World) this);
        player.setPosition(startPosition());
        player.addCollisionListener(new Pickup(game, this));

    }

    /**
     * The initial position of the player.
     */
    public abstract Vec2 startPosition();

    /**
     * The number of treasures collected.
     */
    public abstract boolean treasureCount();

    /**
     * Is this level complete?
     */
    public abstract boolean isCompleted();

}
