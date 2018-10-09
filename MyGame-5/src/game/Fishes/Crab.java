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
public class Crab extends Fish {
    public Crab (World w) {
            super(w);
    
    
    PolygonShape shape = new PolygonShape(
          -2.21f,1.47f, 2.18f,1.47f, 2.17f,-1.44f, -2.2f,-1.46f, -2.22f,1.43f);

 this.addImage(new BodyImage("data/crab.png",5.0f));//Image taken from http://www.stickpng.com/img/at-the-movies/cartoons/finding-nemo/nemo-side-view
    SolidFixture fixture = new SolidFixture(this, shape);
    fixture.setRestitution(1);
   // private int liveCount;


           
}
}