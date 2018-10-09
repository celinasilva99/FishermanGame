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
import game.Fishes.Whale;
import static java.awt.Color.blue;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import org.jbox2d.common.Vec2;

/**
 *
 * @author cs
 */
public class LevelThree extends GameLevel implements ActionListener {
   
private Fish fish;
    private Shark s;
    private Hook hook;
    private Hook MainFish;
    private Hook Hook;
    private Timer timer;
    private MainFish m;
    private Whale w;
      private static final int NUM_FISH = 15;
      private static final int Treasure = 2;
    @Override
    public void populate (Game game){
        super.populate(game);
        timer = new Timer(1000, this);
        timer.setInitialDelay(120000);
        timer.start();
        Shape shape = new BoxShape(20f, 0.1f);
        Body ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0, -20f));
        ground.setFillColor(blue);

        // make a platform
        Shape wallShape = new BoxShape(0.1f, 20f);
        Body leftWall = new StaticBody(this, wallShape);
        leftWall.setPosition(new Vec2(20, 0f));
        Body rightWall = new StaticBody(this, wallShape);
        rightWall.setPosition(new Vec2(-20f, 0f));

        Shape shape1 = new BoxShape(20f, 0.1f);
        Body ceiling = new StaticBody(this, shape);
        ceiling.setPosition(new Vec2(0, 20f));
        ceiling.setFillColor(blue);

        int max = 20;
        int min = -20;
        int range = (max - min) + min;

       for(int i = 0; i<5;i++)
            {
            
            int c = (int)(Math.random()* ((max-min))+min);
            int g = (int)(Math.random()* ((max-min))+min);
            int a = (int)(Math.random()* ((max-min))+min);
            int b = (int)(Math.random()* ((max-min))+min);
            int x = (int)(Math.random()* ((max-min))+min);
            Dolphin d = new Dolphin(this);
            d.setPosition(new Vec2(x,c));
            d.setLinearVelocity(new Vec2(-2,0));
            d.setGravityScale(0);

            RedFish r = new RedFish(this);
            r.setPosition(new Vec2(c,g));
            r.setLinearVelocity(new Vec2(8,-7));
            r.setGravityScale(0);

            Octopus o = new Octopus(this);
            o.setPosition(new Vec2(g,x));
            o.setLinearVelocity(new Vec2(2,7));
            o.setGravityScale(0);

            }
        for(int i = 0; i<4;i++){
            int k = (int)(Math.random()* ((max-min))+min);
            int l = (int)(Math.random()* ((max-min))+min);
            Treasure t = new Treasure(this);
            t.setPosition(new Vec2(l,k));
           // t.setAngularVelocity(5);
            //t.setGravityScale(0);
            t.addCollisionListener(new Pickup(game,this));
       
       }
       

            int d = (int) (Math.random() * ((max - min)) + min);
            int b = (int) (Math.random() * ((max - min)) + min);
            s = new Shark(this);
            s.setPosition(new Vec2(d, d));
            s.setLinearVelocity(new Vec2(2, 0));
            s.setAngularVelocity(5);
            s.setGravityScale(0);
           // s.addCollisionListener(new Pickup(game));


        for (int i = 0; i < 4; i++) {
            int e = (int) (Math.random() * ((max - min)) + min);
            int f = (int) (Math.random() * ((max - min)) + min);
            m = new MainFish(this);
            m.setPosition(new Vec2(e, f));
            m.addCollisionListener(new Pickup(game,this));
            //m.addCollisionListener(new SharkCollision(s, this, m));
            m.setLinearVelocity(new Vec2(3, 2));
            m.setGravityScale(1);
        }
            w = new Whale(this);
            w.setPosition(new Vec2(8,-7));
            w.setGravityScale(2);
            w.setLinearVelocity(new Vec2(3, 2));
            
    }
    

    @Override
    public Vec2 startPosition() {
        Vec2 pos = new Vec2(0.0f, 0.0f);
        this.getPlayer().setPosition(pos);
        return pos;
    }

    @Override
    public boolean isCompleted() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       return getPlayer().getFishCount() == NUM_FISH;
 
    }

    @Override
    public boolean treasureCount() {
       return getPlayer().getTreasureCount() == Treasure;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Component frame = null;
        JOptionPane.showMessageDialog(frame, "Time is up!");
        this.stop();
    }


}

