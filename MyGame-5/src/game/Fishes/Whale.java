/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Fishes;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;

/**
 *
 * @author cs
 */
public class Whale extends Fish{
    public Whale (World w) {
            super(w);
    
    
    PolygonShape shape = new PolygonShape(
            -1.43f,1.46f, 1.42f,1.48f, 1.41f,-1.47f, -1.43f,-1.48f, -1.44f,1.44f);

 this.addImage(new BodyImage("data/whale.png",5.0f));//Image taken from http://www.stickpng.com/img/at-the-movies/cartoons/finding-nemo/nemo-side-view
    SolidFixture fixture = new SolidFixture(this, shape);
    fixture.setRestitution(1);
   // private int liveCount;


           
          
    }
   

   
}
