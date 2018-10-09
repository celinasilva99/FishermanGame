/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Fishes.Crab;
import game.Fishes.MainFish;
import game.Fishes.Shark;
import game.Fishes.Whale;
import java.awt.Component;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jbox2d.common.Vec2;

/**
 *
 * @author cs
 */
public class Pickup implements CollisionListener {

    private Hook hook;
    private Treasure treasure;
    float max = 20;
    float min = -20;
    private GameLevel world;
    private Game game;
    private MainFish fish;
    Component frame = null;
    private String highScore = "";
     private int level = 1;
    public Pickup(Game game, GameLevel world) {

        //this.hook = hook;
        this.world = world;
        this.game = game;
      
    }

    @Override
    public void collide(CollisionEvent e) {
        Hook player = game.getPlayer();
        if (e.getReportingBody() instanceof MainFish && e.getOtherBody() == player) {
            int c = (int) (Math.random() * ((max - min)) + min);
            int g = (int) (Math.random() * ((max - min)) + min);
            
            System.out.println("Collide");
            //System.out.println( hook.getFishCount());
            player.incrementFishCount();
            player.destroy1();
            e.getReportingBody().setPosition(new Vec2(c, g));

        }
if (e.getOtherBody() instanceof Treasure && e.getReportingBody() instanceof MainFish) {
            System.out.println("Yummy!");
            player.incrementTreasureCount();
            player.gainLife();
            e.getOtherBody().destroy();
        }

        if (e.getReportingBody() instanceof MainFish && e.getOtherBody() instanceof Whale) {
            player.destroy2();
            game.stop();
            System.out.println("Whale Collides with fish");
            
            JOptionPane.showMessageDialog(frame, "Out! Be Careful Of the Killer Whale ");
        }

        if (e.getReportingBody() instanceof MainFish && e.getOtherBody() instanceof Crab) {
            player.destroy2();
            game.stop();
            System.out.println("Whale Collides with fish");
           
       
            JOptionPane.showMessageDialog(frame, "Oh NO! CRAB CLAWS,Try Again ");
        }

        if (game.isCurrentLevelCompleted()){
            
            System.out.println("Go to the Next level...");
            JOptionPane.showMessageDialog(frame, "Congratulations,level Completed");
            game.goNextLevel();
        } 
        
 if(e.getReportingBody() instanceof MainFish && e.getOtherBody() instanceof Shark){
             //System.out.println("Lives Remaining; "+ fish.getliveCount());
            player.destroy();
            player.decrementLiveCount();
            if(player.getliveCount() == 0){
                player.destroy2();
            e.getReportingBody().destroy();
//            game.checkScore();
            System.out.println("OUT!!");
            JOptionPane.showMessageDialog(frame, "OUT");
//           game.checkScore();
            game.stop();
    

        } 
          
    }
}
}