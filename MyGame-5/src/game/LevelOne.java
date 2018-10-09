/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import game.Fishes.Dolphin;
import game.Fishes.Fish;
import game.Fishes.MainFish;
import game.Fishes.Octopus;
import game.Fishes.RedFish;
import game.Fishes.Shark;
import static java.awt.Color.blue;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import org.jbox2d.common.Vec2;

/**
 * LevelOne.java includes all the objects that are present in level 1 of the
 * game.
 *
 * @author cs
 */
public class LevelOne extends GameLevel implements ActionListener {

    /**
     * An object Fish of type fish
     */
    private Fish fish;
    /**
     * An object s of type shark;
     */
    private Shark s;
    /**
     * An object hook of type Hook
     */
    private Hook hook;
    /**
     * An object m of type MainFish
     */
    private MainFish m;
    /**
     * An object treasure of type treasure
     */
    private Treasure treasure;
    /**
     * An object timer of type timer
     */
    private Timer timer;
    /*
    * The variable if NUM_FISH in the field
    * Indicates the number of fishes needeed to be completed in order to move to the next level.
    
     */
    private static final int NUM_FISH = 15;
    /**
     * The variable is Treasure in the field.
     */

    private static final int Treasure = 1;

    @Override
    /**
     * Populate the world of this level
     *  @param Game the game in which this body exists.
     */

    public void populate(Game game) {
        super.populate(game);
        /**
         * Creates a new timer
         */
        timer = new Timer(1000, this);
        timer.setInitialDelay(180000);
        timer.start();
        /**
         * Creates a new BoxShape of the ground of type shape Creates a ground
         * StsticBody of type body. Sets the colour to blue
         */
        Shape shape = new BoxShape(20f, 0.1f);
        Body ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0, -20f));
        ground.setFillColor(blue);

        /**
         * Creates the left and right wallShape of type Shape Creates          *
         */
        Shape wallShape = new BoxShape(0.1f, 20f);
        Body leftWall = new StaticBody(this, wallShape);
        leftWall.setPosition(new Vec2(20, 0f));
        Body rightWall = new StaticBody(this, wallShape);
        rightWall.setPosition(new Vec2(-20f, 0f));

        Shape shape1 = new BoxShape(20f, 0.1f);
        Body ceiling = new StaticBody(this, shape);
        ceiling.setPosition(new Vec2(0, 20f));
        ceiling.setFillColor(blue);
        /**
         * The max co-ordinate of the position of the object
         *
         */
        int max = 20;
        /**
         * The min co-ordinate of the position of the object
         *
         */
        int min = -20;

        /**
         * The loop for all the fishes Creates 5 of each fishes.
         */
        for (int i = 0; i < 5; i++) {
            /**
             * Variables generating random positions for all the fishes
             */
            int c = (int) (Math.random() * ((max - min)) + min);
            int g = (int) (Math.random() * ((max - min)) + min);
            int a = (int) (Math.random() * ((max - min)) + min);
            int b = (int) (Math.random() * ((max - min)) + min);
            int x = (int) (Math.random() * ((max - min)) + min);
            /**
             * Creates a new dolphin of type Dolphin in the world
             * Moves randomly using the random co-ordinates.
             */
            Dolphin dolphin = new Dolphin(this);
            dolphin.setPosition(new Vec2(x, c));
            dolphin.setLinearVelocity(new Vec2(-2, 0));
            dolphin.setGravityScale(0);
            /**
             * Creates a new redFish of type RedFish in the world
             * Moves randomly using the random co-ordinates(c,g)
             */
            RedFish redFish = new RedFish(this);
            redFish.setPosition(new Vec2(c, g));
            redFish.setLinearVelocity(new Vec2(8, -7));
            redFish.setGravityScale(0);
            /**
             * Creates a new octopus of type Octopus in the world 
             * Moves randomly using the random co-ordinates(g,x)
             */
            Octopus octopus = new Octopus(this);
            octopus.setPosition(new Vec2(g, x));
            octopus.setLinearVelocity(new Vec2(2, 7));
            octopus.setGravityScale(0);

        }
        /**
             * Variables generating random positions for treasure
             */
        int c = (int) (Math.random() * ((max - min)) + min);
        int a = (int) (Math.random() * ((max - min)) + min);
        /**
             * Creates a new treasure of type Treasure in the world
             * Moves randomly using the random co-ordinates(a,c)
             */

        treasure = new Treasure(this);
        treasure.setPosition(new Vec2(a, c));
       

        /**
             * Variables generating random positions for the shark
             */
        int d = (int) (Math.random() * ((max - min)) + min);
        int b = (int) (Math.random() * ((max - min)) + min);
        /**
             * Creates a new shark of type Shark
             * Moves randomly using the random co-ordinates(a,d)
             */
        s = new Shark(this);
        s.setPosition(new Vec2(a, d));
        s.setLinearVelocity(new Vec2(2, 0));
        s.setAngularVelocity(5);
        // s.addCollisionListener(new Pickup(game));
        s.setGravityScale(0);
        s.setLinearVelocity(new Vec2(2, 2));

        for (int i = 0; i < 4; i++) {
            /**
             * variables generating random positions for the mainFish
             */
            int e = (int) (Math.random() * ((max - min)) + min);
            int f = (int) (Math.random() * ((max - min)) + min);
            /**
             * Creates a new m of type MainFish in the world
             * Moves randomly using the random co-ordinates(e,f)
             * 
             */
            m = new MainFish(this);
            m.setPosition(new Vec2(e, f));
            m.addCollisionListener(new Pickup(game, this));
            //m.addCollisionListener(new SharkCollision(s, this, m));
            m.setLinearVelocity(new Vec2(3, 2));
            m.setGravityScale(1);
        }
    }
    /**
     * 
     * @return The start position of the player.
     */
    @Override
    public Vec2 startPosition() {
        Vec2 pos = new Vec2(0.0f, 0.0f);
        this.getPlayer().setPosition(pos);
        return pos;
    }
/**
 * 
 * @return The number of fishes collected by the player
 */
    @Override
    public boolean isCompleted() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return getPlayer().getFishCount() == NUM_FISH;

    }
/**
 * 
 * @return  The number of treasure collected by the player
 */
    @Override
    public boolean treasureCount() {
        return getPlayer().getTreasureCount() == Treasure;
    }
/**
 * Level one stops when the time is up
 * @param e is type of ActionEvent which displays the JOptionPane message
 */
    @Override
    public void actionPerformed(ActionEvent e) {
        Component frame = null;
        JOptionPane.showMessageDialog(frame, "Time is up!");
        this.stop();

    }
}
