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


     public class MainFish extends Fish {
         private int liveCount;
    
    
         public MainFish (World w) {
            super(w);
            
            liveCount = 3;

    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance. 
    // That means there is a single shape and image for all instances of the class.
  PolygonShape shape = new PolygonShape(
            -1.33f,-1.16f, 1.17f,-0.84f, 1.3f,0.9f, -0.56f,1.08f, -1.32f,0.5f, -1.33f,-1.15f);
    this.addImage(new BodyImage ("data/fish.png",3.0f));//Image taken from http://www.stickpng.com/img/at-the-movies/cartoons/finding-nemo/nemo-side-view
    SolidFixture fixture = new SolidFixture(this, shape);
    fixture.setRestitution(1);
         }
    //liveCount = 3;

    /**
     *
     * @return
     */
     }
     





